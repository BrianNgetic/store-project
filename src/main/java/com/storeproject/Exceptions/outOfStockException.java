package com.storeproject.Exceptions;



public class outOfStockException extends Exception{
    public outOfStockException(){
        super("This item is out of Stock");
    }
    public outOfStockException(String message){
        super(message);
    }
}