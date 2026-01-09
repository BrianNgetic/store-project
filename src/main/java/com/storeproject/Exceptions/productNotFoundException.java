package com.storeproject.Exceptions;

public class productNotFoundException  extends Exception{
    public productNotFoundException(){
        super("Sorry, the product is not available");
    }
    public productNotFoundException(String message){
        super(message);
    }
}
