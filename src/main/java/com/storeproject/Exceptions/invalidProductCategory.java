package com.storeproject.Exceptions;

public class invalidProductCategory extends Exception {
        public invalidProductCategory(){
            super("Invalid Category: Please Enter a Valid Category(Food, Electronic, Clothing)");

        }
        public invalidProductCategory(String message){
            super(message);
        }
}
