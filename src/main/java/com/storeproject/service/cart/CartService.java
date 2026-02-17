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
    // public List<CartItem>  viewCart(Users user){
    //       Cart cart = cartRepository.findUser(user); //find the users cart
    //         List<CartItem> cartresult = new ArrayList<>();
    //         cartresult.addAll(cartRepository.findAll());
    //     return cartresult;
    // }


    // public Long getTotal(){

    //          List<CartItem> cartresult = new ArrayList<>();
    //         cartresult.addAll(cartRepository.findAll());

    //         Long total ;
    //         for(int i = 0; i < cartresult.size(); i++){
    //             int count = cartresult.get(i).getTotal();
    //         }
    // }

    //delefated the bottom to 
    // public void addToCart(Long id) throws productNotFoundException{
    //           Optional<Product> product = productRepository.findById(id);
    //           if(product.isPresent()){
                    
    //           }
    //          else{
    //             throw new productNotFoundException();
    //           }
    // }
}
