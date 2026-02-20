package com.storeproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
public class Order {

    public enum Status{
        pending, paid, shipped, completed, cancelled
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long Id;

    @ManyToOne
    @JoinColumn(name  = "user_id")
    protected Users user;

    @Column(name = "OrderDate")
    protected LocalDateTime orderDate;

    @Column (name = "OrderStatus")
    protected Status status;

    @Column(name = "Total")
    protected double total;

    
    @Column(name = "address")
    protected String address;

    @Column(name = "payment")
    protected Payment payment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> userOrderItems;



    
}
