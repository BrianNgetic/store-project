package com.storeproject.Exceptions;



public class emailAlreadyExistsException  extends Exception{

    public emailAlreadyExistsException(){
        super("Sorry, this Email is already in use");
    }

    public emailAlreadyExistsException(String message){
        super(message);
    }
    
}
