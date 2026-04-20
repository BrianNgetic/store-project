package com.storeproject.Exceptions;

public class noNutritionInfoGiven  extends RuntimeException{

    public noNutritionInfoGiven()
{
    super("No Nutrition info given");
}    
    public noNutritionInfoGiven(String message){
        super(message);
    }
}
