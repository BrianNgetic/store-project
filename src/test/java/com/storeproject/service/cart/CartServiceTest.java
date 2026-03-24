package com.storeproject.service.cart;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.storeproject.repository.*;
import com.storeproject.model.Users;
import com.storeproject.model.Cart;
import com.storeproject.model.CartItem;
import com.storeproject.model.Product;
import com.storeproject.model.Clothing;
@DataJpaTest
public class CartServiceTest {

    //create a user
    //create a cart for the user
    //create a cartItem
    //addtocart

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    Users users1 ;
    Cart ThisUsersCart;
    CartItem cartItem  = new CartItem();
    Product desiredProduct;
     Clothing clothing ;

    @BeforeEach
    public void Setup(){
         users1 = new Users();
            users1.setUsername("brian");
            users1.setPassword("password");
            users1.setFullname("brian ngetich");
            users1.setEmail("examplemail@gmail.com");
            users1.setAddress("1111 address ");
            users1.setCity("houston");
            users1.setState("arizona");
            users1.setZip("63088");

        clothing = new Clothing(
                "North Face Puffer Jacket",
                "clothing",
                "jacket",
                45.0,
                45,
                "M",
                "Blue");

        ThisUsersCart  = new Cart();
            
        cartItem.setProduct(clothing);
        cartItem.setCart(ThisUsersCart);
        cartItem.setQuantity(4);


            

    }

        
   @Test
    public void addToCart_shouldIncreaseQuantity_whenProductAlreadyInCart(){
    
       
        
        assumeTrue(ThisUsersCart.cartContains(cartItem));//assuming it  has
            //get initial quantity before adding
        int num = cartItem.getQuantity();

        ThisUsersCart.addToUserCart(cartItem);
            

            //check if the count has increased
        assertEquals(cartItem.getQuantity(), (num + 1));



    }

    @Test
    public void addToCart_shouldCreateCartItem_whenProductNotInCart(){
            assumeFalse(ThisUsersCart.cartContains(cartItem));

            //check if the item is in the cartItemRepository
            //ifnot, lets create one and add it to the acart

            
            //create a new cartItem;
            CartItem newCartItem = new CartItem();
            cartItem.setProduct(desiredProduct);
            cartItem.setCart(ThisUsersCart);
            cartItem.setQuantity(4);
            
            ThisUsersCart.addToUserCart(newCartItem);

            //check that it is now in the cart

            assertTrue(ThisUsersCart.cartContains(newCartItem));


    }

}


