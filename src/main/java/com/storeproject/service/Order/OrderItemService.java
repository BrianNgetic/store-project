package com.storeproject.service.Order;

import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.storeproject.model.*;
import com.storeproject.repository.*;

@Service
public class OrderItemService {

    private final OrderRepository orderRepository;
    //get the current user
    //get their cart
    //loop through their cartItems and make everyOne of them an order Item
    
    private  CartRepository cartRepository;
    private  CartItemRepository cartItemRepository ;
    private ProductRepository productRepository;

    public OrderItemService(
                CartRepository cartRepository,
                CartItemRepository cartItemRepository,
                ProductRepository productRepository

    , OrderRepository orderRepository){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }
 

public void  createOrderItem(Order order, Long id){
    //create a new orderItem
    OrderItem orderItem = new OrderItem();
    //get the cartItem
    CartItem thisCartItem = cartItemRepository.findbyId(id);
    Product thisProduct = cartItemRepository.findByProduct(thisCartItem.getProduct());


    //populate the fields
    orderItem.setOrder(order);
    orderItem.setProduct(thisProduct);
    orderItem.setProdName(thisProduct.getName());
    orderItem.setPriceAtPurchase(thisProduct.getPrice());

    
   


}



}
