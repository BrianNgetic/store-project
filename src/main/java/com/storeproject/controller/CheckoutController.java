package com.storeproject.controller;

import org.springframework.web.bind.annotation.*;
import org.hibernate.StaleObjectStateException;
import org.springframework.http.*;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.*;

import org.springframework.retry.annotation.Backoff;

import com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException;
import com.storeproject.model.*;

import com.storeproject.service.Order.OrderService;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    private final OrderService orderService;

    public CheckoutController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Retryable(retryFor = {
            org.springframework.dao.ConcurrencyFailureException.class,
            org.springframework.dao.CannotAcquireLockException.class
    }, maxAttempts = 5, backoff = @Backoff(delay = 100, maxDelay = 500, multiplier = 2.0, random = true)
    )
    @PostMapping
    public ResponseEntity<?> checkout() throws Exception {

        orderService.checkout();
        return ResponseEntity.ok().build();

    }

}
