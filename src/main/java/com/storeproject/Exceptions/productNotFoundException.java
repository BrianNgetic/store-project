package com.storeproject.Exceptions;

public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(){
        super("Sorry, product not found");

    }
    
    public ProductNotFoundException(String message){
        super(message);
    }
}
