package com.storeproject.Exceptions;



public class outOfStockException extends RuntimeException{
    public outOfStockException(){
        super("This item is out of Stock");
    }
    public outOfStockException(String message){
        super(message);
    }
}