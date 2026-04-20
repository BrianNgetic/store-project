package com.storeproject.Exceptions;

public class noNutritionInfoException  extends RuntimeException{
    public noNutritionInfoException(){
        super("No nutrion information available");
    }

    public noNutritionInfoException(String message){
        super(message);
    }
    
}
