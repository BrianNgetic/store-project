package com.storeproject.Exceptions;

public class invalidProductCategoryException extends Exception {
        public invalidProductCategoryException(){
            super("Invalid Category: Please Enter a Valid Category(Food, Electronic, Clothing)");

        }
        public invalidProductCategoryException(String message){
            super(message);
        }
}
