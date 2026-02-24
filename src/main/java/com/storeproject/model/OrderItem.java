package com.storeproject.model;

// import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderItemId")
    protected Long id;

     @ManyToOne
    @JoinColumn(name = "order_id")
    protected Order order;

    @ManyToOne
    @JoinColumn(name = "prodId")
    protected Product product;
    
    protected double  priceAtPurchase;
    
}
