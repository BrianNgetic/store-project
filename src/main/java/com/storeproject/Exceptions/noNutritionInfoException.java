package com.storeproject.Exceptions;

public class noNutritionInfoException  extends Exception{
    public noNutritionInfoException(){
        super("No nutrion information available");
    }

    public noNutritionInfoException(String message){
        super(message);
    }
    
}
