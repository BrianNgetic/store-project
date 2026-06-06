package com.storeproject.service.Order;

import java.time.LocalDateTime;
import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;



import com.storeproject.model.*;
import com.storeproject.model.Order.Status;
import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderService{
    //get the current user

    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    // private final PaymentService paymentService;

    public OrderService(UsersRepository usersRepository,
                        CartRepository cartRepository,
                        OrderRepository orderRepository,
                        ProductRepository productRepository

                       ){
        this.usersRepository = usersRepository;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        // this.paymentService = paymentService;
       
    }

Users getCurrentUser() throws RuntimeException{
             //get the current user
             Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        

             Object principal  = auth.getPrincipal();
    String username;
            if(principal instanceof UserDetails){
                     username = ((UserDetails) principal).getUsername();
             } else {
               username = principal.toString();
            }
    if(usersRepository.findByUsername(username).isPresent()){
        return usersRepository.findByUsername(username).get();
    }
    

    throw new UserNotFoundException("No authenticated user");
}



    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void  checkout() throws RuntimeException{
       
        //get the users cart
        Cart cart  = cartRepository.findByUser(getCurrentUser());

        
        //create a new order
        Order order  = new Order();
        order.setUser(getCurrentUser());
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(cart.getTotal());
        order.setAddress(getCurrentUser().getAddress());
        // orderRepository.save(order);
      
        //get the cart items
        List<CartItem> thisUsersCartItems =  cart.getUserCartItems();

        //for each, convert to orderitem
      List<OrderItem> newOrders = new ArrayList<>();
        for(CartItem item: thisUsersCartItems){
    
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setProduct(item.getProduct());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setPriceAtPurchase(item.getProduct().getPrice());
            

                if(orderItem.getQuantity() > orderItem.getProduct().getStock()){
                        throw new outOfStockException();
                }

                
                newOrders.add(orderItem);

        }

        newOrders.forEach(tempOrder -> order.addToUserOrder(tempOrder));
      

        //before going through with payment processing
        order.setStatus(Status.pending);

        orderRepository.save(order);

        //only for simulation before adding actual payment methods
        String paymentMethod = "1111 2222 3333 4444";
    

        //go through with payment
        

        //create a payment entity
        Payment thisPayment =    new Payment();
        thisPayment.setOrder(order);
        thisPayment.setPaymentMethod(paymentMethod);
        thisPayment.setOrderedAt(LocalDateTime.now());

         Random gen = new Random();
        thisPayment.setUUID(gen.nextLong());

      //jus for testing, 
        order.setStatus(Status.paid);
        
        //once the payment goes through
        if(order.getStatus() == Status.paid){
            
            List<CartItem> toBeDeleted = new ArrayList<>();
            
            for(CartItem item: thisUsersCartItems){
               Product product = productRepository.findByIdForUpdates(
                item.getProduct().getId()
               );
         
               product.setStock(product.getStock() - item.getQuantity());
               
               toBeDeleted.add(item);
       
                
            }
                //got a concurrentModificationException before i added this
                toBeDeleted.forEach(temp -> cart.deleteFromUserCart(temp));
               

        }
      
    
        
        


    }







}
