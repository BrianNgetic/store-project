package com.storeproject.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Payment {

    public  enum Status{
        SUCCESS, PENDING, FAILED
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    protected Order order;

    @Column(name = "paymentMethod")
    String paymentMethod;


    @Column(name = "PaymentStatus")
    @Enumerated(EnumType.STRING)
    protected Status status;

    @Column(name = "UUID")
    protected Long UUID;

    protected LocalDateTime orderedAt;

}
