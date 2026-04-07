package com.storeproject.service.Order;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.test.context.ActiveProfiles;

import com.storeproject.repository.CartItemRepository;
import com.storeproject.repository.CartRepository;
import com.storeproject.repository.ProductRepository;
import com.storeproject.repository.UsersRepository;
import com.storeproject.repository.OrderRepository;
import com.storeproject.repository.OrderItemRepository;
import com.storeproject.model.*;
import com.storeproject.model.Order;
import com.storeproject.service.Order.OrderService;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.context.SecurityContext ; 
import org.springframework.security.core.Authentication ;


@SpringBootTest
@ActiveProfiles("test")
public class CheckoutServiceTest {

    @Autowired OrderService orderService;
    @Autowired UsersRepository usersRepository;
    @Autowired ProductRepository productRepository;
    @Autowired CartRepository cartRepository;
    @Autowired CartItemRepository cartItemRepository;
    @Autowired OrderRepository  OrderRepository;
    @Autowired OrderItemRepository orderItemRepository;


    

    @Test
    void concurrectCheckoutTest() throws InterruptedException{
        //50 concurrent users
        int usersCount = 50;

        Electronics electronic  = new  Electronics(
                    "Samsung Galaxy S23",
                    "Electronic" ,
                    "phone",
                    244.99,
                    10,
                    true, 
                    30,
                     2.0);
            electronic.setId(null);
        productRepository.save(electronic);
        for(int i = 0; i < usersCount; i++){
            
            Users user = new Users("user"+i, "pass", " ", " ", " ", " "," ", " ");
            usersRepository.save(user);

            

            Cart cart = new Cart();
            cart.setUser(user);
            cartRepository.save(cart);
          

            CartItem cartItem = new CartItem();
            cartItem.setCart(cart); 
            cartItem.setProduct(electronic);
            cartItem.setQuantity(2);
            cartItemRepository.save(cartItem);

            cart.addToUserCart(cartItem);
        
        

        }   

        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(usersCount);


        for(int i = 0 ; i < usersCount; i++){
            String username = "user"+i;

            pool.submit(() -> {
                try{
                    Authentication auth =  new UsernamePasswordAuthenticationToken(username, null, List.of());

                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    context.setAuthentication(auth);
                    SecurityContextHolder.setContext(context);


                    
                    //    System.out.println("User (" + i + ") " + username + " Stock" + orderItem.getProduct().getStock());
                    orderService.checkout();
                 
                }
                catch(Exception e){
                    e.printStackTrace();

                }finally{
                    SecurityContextHolder.clearContext();
                    latch.countDown();
                }
            });

        }

        latch.await();;
        pool.shutdown();


        Product updated = productRepository.findById(electronic.getId()).get();
        assertEquals(0, updated.getStock());

    }


//     @Test
//    public void  checkout_shouldCreateOrder_whenPaymentIsValid(){

//    }

//    @Test
//    public void checkout_shouldFail_whenCartIsEmpty(){
    
//    }
}
