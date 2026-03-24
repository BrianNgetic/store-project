package com.storeproject.service.Order;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CheckoutServiceTest {
    @Test
   public void  checkout_shouldCreateOrder_whenPaymentIsValid(){
    
   }

   @Test
   public void checkout_shouldFail_whenCartIsEmpty(){
    
   }
}
