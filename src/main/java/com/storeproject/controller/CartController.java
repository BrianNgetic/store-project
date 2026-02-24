package com.storeproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;


import com.storeproject.model.*;
import com.storeproject.dto.*;
import com.storeproject.service.cart.CartItemService;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    private final CartItemService cartItemService;



    public CartController(CartItemService cartItemService){
        this.cartItemService = cartItemService;
        
    }
    @PostMapping("/add-item")//
    public ResponseEntity<?> addToCart(@RequestBody AddToCartDto addToCartDto) throws Exception{
        cartItemService.addToCart(addToCartDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFromCart(@PathVariable Long id) throws Exception{
        cartItemService.deleteFromCart(id);

        return ResponseEntity.ok("Deleted product" + id + " from cart");
    }

    @GetMapping("view")
    public ResponseEntity<List<GetCartSummaryDto>> viewCart() throws Exception{
        return ResponseEntity.ok(cartItemService.viewCart());

    }

}
