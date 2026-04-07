package com.storeproject.service.cart;

import java.util.*;
import com.storeproject.service.product.ProductService;
import org.springframework.stereotype.Service;

import com.storeproject.model.*;
import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;

@Service
public class CartService {

    private final ProductService productService;
    private final ProductRepository productRepository;


    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
   

    public CartService(CartRepository cartRepository,
                 ProductService productService,
                 ProductRepository productRepository,
                 CartItemRepository cartItemRepository){
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.productRepository  = productRepository;
     this.cartItemRepository = cartItemRepository;
         }
    
    
    public void CreateCart(Users user) throws Exception{

            Cart cart = cartRepository.findByUser(user);

         
    }
 
}
