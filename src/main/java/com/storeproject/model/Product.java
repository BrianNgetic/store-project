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
    @Column(name = "prodId", nullable = false)
    protected  Long id;
    

    @Column(name = "prodName", nullable  = false)
    protected String name;
  
     @Column (name = "prodCategory", nullable = false)
    protected String category;
     
    @Column (name = "prodType" ,nullable = false)
    protected String type;

    
  

    @Column (name = "prodPrice", nullable = false)
    @Min(value = 0, message =  "Price can not be a negative")
    protected double  price;

    @Column (name = "prodStock" ,nullable = false)
    @Min(value = 0, message =  "Stock can not be a negative")
    protected int stock;

   

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

