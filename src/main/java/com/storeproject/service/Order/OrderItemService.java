package com.storeproject.service.Order;

import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.storeproject.model.*;
import com.storeproject.repository.*;

@Service
public class OrderItemService {



  
    //get the current user
    //get their cart
    //loop through their cartItems and make everyOne of them an order Item
     
    private  CartRepository cartRepository;
    private  CartItemRepository cartItemRepository ;
    private ProductRepository productRepository;
    private OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;

    public OrderItemService(
                CartRepository cartRepository,
                CartItemRepository cartItemRepository,
                ProductRepository productRepository,
                OrderItemRepository orderItemRepository,
                OrderRepository orderRepository){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }
 

public void  createOrderItem(Order order, CartItem cartItem ){
    //create a new orderItem
    OrderItem orderItem = new OrderItem();
    //get the cartItem;
    CartItem thisCartItem = cartItem;
    Product thisProduct = thisCartItem.getProduct();


    //populate the fields
    orderItem.setOrder(order);
    orderItem.setProduct(thisProduct);
    orderItem.setPriceAtPurchase(thisProduct.getPrice()); //to be improvedd

    orderItemRepository.save(orderItem);




}



}
