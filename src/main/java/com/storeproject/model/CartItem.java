package com.storeproject.model;

import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    

    @ManyToOne
    @JoinColumn(name  = "prodId")
    protected Product product;
    


    @ManyToOne
    @JoinColumn(name = "cart_id")
    protected Cart cart;

    @Column(name = "quantity")
    protected int quantity;


    
    
}
