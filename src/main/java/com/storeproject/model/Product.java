package com.storeproject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id", nullable = false)
    protected  Long id;
    
  
    @Column (name = "prod_name" , nullable = false)
    protected  String name;

    @Column (name = "prod_price", nullable = false)
    protected double  price;

    @Column (name = "prod_stock" ,nullable = false)
    protected int stock;

    @Column (name = "prod_category", nullable = false)
    protected String category;

    public abstract  boolean isInStock();

    public abstract void validate();
}

