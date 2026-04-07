package com.storeproject.service.Order;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import com.storeproject.*;
import com.storeproject.model.*;
import com.storeproject.model.Order.Status;
import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;
import com.storeproject.service.Payment.*;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderService{
    //get the current user

    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final ProductRepository productRepository;
    // private final PaymentService paymentService;

    public OrderService(UsersRepository usersRepository,
                        CartRepository cartRepository,
                        CartItemRepository cartItemRepository,
                        OrderRepository orderRepository,
                        OrderItemRepository orderItemRepository,
                        OrderItemService  orderItemService,
                        ProductRepository productRepository

                       ){
        this.usersRepository = usersRepository;
        this.cartRepository = cartRepository;
         this.cartItemRepository  = cartItemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository  = orderItemRepository;
        this.orderItemService = orderItemService;
        this.productRepository = productRepository;
        // this.paymentService = paymentService;
       
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void  checkout() throws Exception{
       Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        String username= auth.getName();
        
        
        Users user = usersRepository.findByUsername(username).orElseThrow( () -> new UserNotFoundException());
        //get the current users cart
        Cart cart  = cartRepository.findByUser(user);

        //create a new order, and move all th

        Order order  = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(cart.getTotal());
        order.setAddress(user.getAddress());
        orderRepository.save(order);
    
     
      
        //get the cart items
        List<CartItem> thisUsersCartItems =  cart.getUserCartItems();

        //for each, convert to orderitem
      
        for(CartItem item: thisUsersCartItems){
            //convert each cartItem to an orderItem and save it
           orderItemService.createOrderItem(order, item);

                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setProduct(item.getProduct());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setPriceAtPurchase(item.getProduct().getPrice());
                orderItemRepository.save(orderItem);
                if(orderItem.getQuantity() > orderItem.getProduct().getStock()){
                        throw new outOfStockException();
                }
        }

        //before going through with payment processing
        order.setStatus(Status.pending);


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

        // paymentService.processPayment(order,thisPayment);

        // if(thisPayment.getStatus() == Payment.Status.SUCCESS){
        // if(order.getTotal() > 0){
        //     order.setStatus(Status.paid);

        
        

        // }
        // else{
        //     order.setStatus(Status.cancelled);
        // }

        order.setStatus(Status.paid);
        
        //once the payment goes through
        if(order.getStatus() == Status.paid){
            for(CartItem item: thisUsersCartItems){
               Product product = productRepository.findByIdForUpdates(
                item.getProduct().getId()
               );
               product.setStock(product.getStock() - item.getQuantity());
               
                
            }
               cartItemRepository.deleteAll(thisUsersCartItems);
                cart.getUserCartItems().clear(); 

        }
        
        
        //after payment  clear the cart and the cartItems
        
        
        
}





}
