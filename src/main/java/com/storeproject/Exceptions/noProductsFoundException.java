package com.storeproject.Exceptions;



public class noProductsFoundException extends Exception {
  
    public  noProductsFoundException(){
        super("No products found");
    }

    public noProductsFoundException(String message){
        super(message);
    }
}

