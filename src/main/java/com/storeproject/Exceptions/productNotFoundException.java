package com.storeproject.Exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Sorry, product not found");

    }
    
    public ProductNotFoundException(String message){
        super(message);
    }
}
