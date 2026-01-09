package com.storeproject.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.*;
import jakarta.validation.constraints.*;


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
    @Min(value = 0, message =  "Price can not be a negative")
    protected double  price;

    @Column (name = "prod_stock" ,nullable = false)
    @Min(value = 0, message =  "Stock can not be a negative")
    protected int stock;

    @Column (name = "prod_category", nullable = false)
    protected String category;

    public   boolean isInStock(){
        if(stock >= 1){
            return true;
        }
        else{
            return false;
        }
    }

    public abstract void validate();
}

