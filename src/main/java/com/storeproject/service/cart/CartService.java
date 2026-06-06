package com.storeproject.service.cart;

import java.util.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.storeproject.service.product.ProductService;
import com.storeproject.model.*;
import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;
import com.storeproject.repository.UsersRepository;
import com.storeproject.dto.*;;

@Service
public class CartService {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
   
   

    public CartService(CartRepository cartRepository,
                 ProductService productService,
                 ProductRepository productRepository,
                 UsersRepository usersRepository){
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.productRepository  = productRepository;
     this.usersRepository = usersRepository;
         }
    
    
    public void CreateCart(Users user) throws RuntimeException{

            Cart cart = cartRepository.findByUser(user);

         
    }


Users getCurrentUser() throws RuntimeException{
             //get the current user
            Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
        
            if (auth == null || !auth.isAuthenticated() || "anonymousUser".equals(auth.getPrincipal())) {
                    throw new RuntimeException("No authenticated user found in session.");
                }

             Object principal  = auth.getPrincipal();
            String username;
            if(principal instanceof UserDetails){
                     username = ((UserDetails) principal).getUsername();
             } else if(principal != null) {
               username = principal.toString();
            } else {
              throw new RuntimeException("Authentication principal is missing.");
             }

    if(usersRepository.findByUsername(username).isPresent()){
        return usersRepository.findByUsername(username).get();
    }
    

    throw new UserNotFoundException("No authenticated user");
}


    

@Transactional 
    public void addToCart(AddToCartDto req) throws RuntimeException{

           
            Cart cart = cartRepository.findByUser(getCurrentUser());

        
            if(cart == null){
                    cart  = new Cart();
                    cart.setUser(getCurrentUser());
            }
                
                //create the cart item 
                CartItem cartItem  = new CartItem();
                Product product = productRepository.findById(req.getId()). //find the product
                                orElseThrow(() -> new ProductNotFoundException("Product not found"));
                cartItem.setProduct(product);
                cartItem.setCart(cart);
                cartItem.setQuantity(req.getQuantity());

                //add it to the cart
                cart.addToUserCart(cartItem);

        //link the cart to the user
                 cart.setUser(getCurrentUser());

            //save the cart and cartItem to db
            //apperantly I dont even need to do this as it inside a 
            //mannaged transactional method   but since there is a possibility the cart might be null ill do it anyway
              cartRepository.save(cart);

}



@Transactional
public void deleteFromCart(Long id) throws RuntimeException{
    //get the current user
    //get hte product id
    //remove from cart
        Cart cart  = cartRepository.findByUser(getCurrentUser());

        Product tobeDeletedProduct  = productRepository.findById(id).
                                        orElseThrow(() -> new ProductNotFoundException());
     

        cart.deleteFromUserCart(cart.getCartItemByProduct(tobeDeletedProduct));
        
      
        
}

@Transactional
public List<GetCartSummaryDto> viewCart() throws RuntimeException{
    //we have to get the current user first

    Cart cart = cartRepository.findByUser(getCurrentUser());

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



public double getTotal() throws RuntimeException{

    Cart cart = cartRepository.findByUser(getCurrentUser());

   return  cart.getTotal();
   
    
}

 
}
