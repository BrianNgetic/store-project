package com.storeproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;




import com.storeproject.model.*;
import com.storeproject.dto.*;
import com.storeproject.service.cart.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    
    private final CartService cartService;



    public CartController(CartService cartService){
        this.cartService = cartService;
        
    }
    @PostMapping("/add-item")//
    public ResponseEntity<?> addToCart(@RequestBody AddToCartDto addToCartDto) throws RuntimeException{
        cartService.addToCart(addToCartDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFromCart(@PathVariable Long id) throws RuntimeException{
        cartService.deleteFromCart(id);

        return ResponseEntity.ok("Deleted product" + id + " from cart");
    }

    @GetMapping("view")
    public ResponseEntity<List<GetCartSummaryDto>> viewCart() throws RuntimeException{
        return ResponseEntity.ok(cartService.viewCart());

    }

}
