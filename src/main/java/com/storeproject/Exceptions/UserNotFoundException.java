package com.storeproject.Exceptions;



public class UserNotFoundException extends Exception{
    
    public UserNotFoundException(){
        super("Sorry, Username not found");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
    

