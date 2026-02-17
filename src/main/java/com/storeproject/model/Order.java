package com.storeproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Order {

    enum Status{
        pending, paid, shipped, completed, cancelled
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderId")
    protected Long Id;

    @ManyToOne
    @JoinColumn(name  = "userId")
    protected Users user;

    @Column(name = "OrderDate")
    protected LocalDateTime orderDate;

    @Column (name = "OrderStatus")
    protected Status status;

    @Column(name = "Total")
    protected Long total;

    
    @Column(name = "address")
    protected String address;

    @Column(name = "payment")
    protected String paymentMethod;


    
}
