package com.storeproject.Exceptions;



public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(){
        super("Sorry, Username not found");
    }

    public UserNotFoundException(String message){
        super(message);
    }
}
    

