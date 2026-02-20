package com.storeproject.service.Payment;

import java.time.LocalDateTime;

import java.util.*;
import org.springframework.stereotype.*;
import com.storeproject.model.*;
import  static com.storeproject.model.Payment.Status;
import com.storeproject.repository.OrderRepository;

@Service
public class PaymentService {
    

    private final OrderRepository orderRepository;

    private PaymentService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    
    

    public void  processPayment(Order order, Payment payment) throws Exception{
      
       
        
        Order thisOrder = orderRepository.findByOrder(order);       
        double total = thisOrder.getTotal();
        //simulating payment
        if(total > 1000){
            payment.setStatus(Status.SUCCESS);

        }
        else if (total == 0){
            payment.setStatus(Status.FAILED);

        }
        else{
            payment.setStatus(Status.PENDING);
        }

    }
}