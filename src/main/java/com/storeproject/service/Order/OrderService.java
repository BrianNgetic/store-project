package com.storeproject.service.Order;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.*;
import com.storeproject.*;
import com.storeproject.model.*;
import com.storeproject.model.Order.Status;
import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;
import com.storeproject.service.Payment.*;
public class OrderService{
    //get the current user

    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;
    private final PaymentService paymentService;

    public OrderService(UsersRepository usersRepository,
                        CartRepository cartRepository,
                        CartItemRepository cartItemRepository,
                        OrderRepository orderRepository,
                        OrderItemService  orderItemService,
                        PaymentService paymentService){
        this.usersRepository = usersRepository;
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
        this.orderItemService = orderItemService;
        this.paymentService = paymentService;
        this.cartItemRepository  = cartItemRepository;
    }

    public void  checkout() throws Exception{
       Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        String username= auth.getName();
        Users user = usersRepository.findByUsername(username).
            orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        //get the current users cart
        Cart cart  = cartRepository.findByUser(user);

        //create a new order, and move all th

        Order order  = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setTotal(cart.getTotal());
        order.setAddress(user.getAddress());
       
        //get the cart items
        List<CartItem> thisUsersCartItems =  cart.getUserCartItems();

        //for each, convert to orderitem
      
        for(CartItem item: thisUsersCartItems){
            //convert each cartItem to an orderItem;
            orderItemService.createOrderItem(order, item.getId());
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

        paymentService.processPayment(order,thisPayment);

        if(thisPayment.getStatus() == Payment.Status.SUCCESS){
            order.setStatus(Status.paid);
            //clear the cartItems from the users cart
               for(CartItem item: thisUsersCartItems){
            //delete each cartItem from the cart and repository
                    cart.deleteFromUserCart(item);
                    cartItemRepository.delete(item);
                    //save the order
                    orderRepository.save(order);
          }

        }
        else{
            order.setStatus(Status.cancelled);
        }
        

        //after payment  clear the cart and the cartItems
        







        
        
}





}
