package com.storeproject.Exceptions;

public class duplicateProductExpetion  extends Exception{
    public duplicateProductExpetion(){
        super("duplicate products found");
    }
    public duplicateProductExpetion(String message){
        super(message);
    }
}
