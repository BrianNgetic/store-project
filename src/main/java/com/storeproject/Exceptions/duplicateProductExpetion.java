package com.storeproject.Exceptions;

public class duplicateProductExpetion  extends RuntimeException{
    public duplicateProductExpetion(){
        super("duplicate products found");
    }
    public duplicateProductExpetion(String message){
        super(message);
    }
}
