package com.storeproject.service.cart;

import  org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.storeproject.Exceptions.UsernameNotFoundException;
import com.storeproject.Exceptions.outOfStockException;
import com.storeproject.Exceptions.productNotFoundException;
import com.storeproject.model.*;
// import com.storeproject.service.*;
import com.storeproject.service.product.*;

import jakarta.transaction.Transactional;
import java.util.*;
import com.storeproject.repository.*;
import com.storeproject.dto.*;

@Service
public class CartItemService {
     
    // protected C

        private final ProductService productService;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
   

    public CartItemService(CartRepository cartRepository,
                 ProductService productService,
                 ProductRepository productRepository,
                 UsersRepository userRepository,
                 CartItemRepository cartItemRepository){
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.productRepository  = productRepository;
        this.usersRepository = userRepository;
        this.cartItemRepository  =cartItemRepository;
    }

    

//i first make a product a cartitem before i add it to the cart
//i can also jus add the productid to the cart dirrectlu


@Transactional 
    public void addToCart(AddToCartDto req) throws Exception{

        //get the current user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        String username= auth.getName();
        Users user = usersRepository.findByUsername(username).
                                    orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    
     Cart cart = cartRepository.findByUser(user);
     

                        
                               
    if(cart == null){
            cart  = new Cart();
       }
        
    
        //create the cart item 
        CartItem cartItem  = new CartItem();
        Product product = productRepository.findById(req.getId()). //find the product
                        orElseThrow(() -> new productNotFoundException("Product not found"));
        cartItem.setProduct(product);
        cartItem.setCart(cart);
        cartItem.setQuantity(req.getQuantity());

        //add it to the cart
        cart.addToUserCart(cartItem);

//link the cart to the user
    cart.setUser(user);

       //save the cart and cartItem to db
    cartItemRepository.save(cartItem);
      cartRepository.save(cart);



}



@Transactional
public void deleteFromCart(Long id) throws Exception{
    //get the current user
    //get hte product id
    //remove from cart

      //get the current user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        String username= auth.getName();
        Users user = usersRepository.findByUsername(username).
                                    orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        //get the current users cart
        Cart cart  = cartRepository.findByUser(user);

        //going to delete multiple products even from different carts, wont work
        // if(productRepository.existsById(id)){
        //     cartItemRepository.deleteByProdId(id);
        //     return;
        // }

        Product tobeDeletedProduct  = productRepository.findById(id).
                                        orElseThrow(() -> new productNotFoundException());
        // if(tobeDeletedProduct != null){
        //           cart.deleteFromUserCart(cartItemRepository.findById(id));     
        // }

        //get the current cartItem
        CartItem cartItemToBeDeleted = cartItemRepository.findByCartAndProduct(cart, tobeDeletedProduct );
        cart.deleteFromUserCart(cartItemToBeDeleted);
        cartItemRepository.delete(cartItemToBeDeleted);
      
        
}


public List<GetCartSummaryDto> viewCart() throws Exception{
    //we have to get the current user first

      Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        String username= auth.getName();
        Users user = usersRepository.findByUsername(username).
                                    orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    //get the current cart

    Cart cart = cartRepository.findByUser(user);

    List<CartItem> usersCart =  cart.getUserCartItems();
    List<GetCartSummaryDto> summaries = new ArrayList<>();

    for(CartItem item:  usersCart){
        GetCartSummaryDto getCartSummaryDto = new GetCartSummaryDto();
        getCartSummaryDto.setProduct(item.getProduct());
        getCartSummaryDto.setQuantity(item.getQuantity());
        summaries.add(getCartSummaryDto);

    }


    
    return summaries;
}




public double getTotal() throws Exception{

     //we have to get the current user first

      Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        String username= auth.getName();
        Users user = usersRepository.findByUsername(username).
                                    orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    //get the current cart

    Cart cart = cartRepository.findByUser(user);

   return  cart.getTotal();
   
    
}



}
