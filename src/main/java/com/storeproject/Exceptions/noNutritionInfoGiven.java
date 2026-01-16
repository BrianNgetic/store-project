package com.storeproject.Exceptions;

public class noNutritionInfoGiven  extends Exception{

    public noNutritionInfoGiven()
{
    super("No Nutrition info given");
}    
    public noNutritionInfoGiven(String message){
        super(message);
    }
}
