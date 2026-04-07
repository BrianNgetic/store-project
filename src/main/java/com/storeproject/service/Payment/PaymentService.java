package com.storeproject.service.Payment;

import java.time.LocalDateTime;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Propagation;

import com.storeproject.model.*;
import com.storeproject.Exceptions.*;
import  static com.storeproject.model.Payment.Status;
import com.storeproject.repository.OrderRepository;

import org.springframework.transaction.annotation.Transactional;
@Service
public class PaymentService {
    

    private final OrderRepository orderRepository;

  public  PaymentService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    
    

    @Transactional(propagation = Propagation.REQUIRED)
    public void  processPayment(Order order, Payment payment) throws Exception{
      
       

        Order thisOrder = orderRepository.getReferenceById(order.getId());
                               
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