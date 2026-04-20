package com.storeproject.Exceptions;

public class invalidProductCategoryException extends RuntimeException {
        public invalidProductCategoryException(){
            super("Invalid Category: Please Enter a Valid Category(Food, Electronic, Clothing)");

        }
        public invalidProductCategoryException(String message){
            super(message);
        }
}
