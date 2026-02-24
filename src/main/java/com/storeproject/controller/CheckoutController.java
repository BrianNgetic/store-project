package com.storeproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;


import com.storeproject.model.*;

import com.storeproject.service.Order.OrderService;
@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final OrderService orderService;

    public CheckoutController(OrderService orderService){
        this.orderService = orderService;
    }


    @PostMapping 
    public ResponseEntity<?>  checkout() throws Exception{

        orderService.checkout();

        return ResponseEntity.ok().build();

    }
    
}
