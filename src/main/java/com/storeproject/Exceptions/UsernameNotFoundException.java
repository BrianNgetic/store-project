package com.storeproject.Exceptions;



public class UsernameNotFoundException extends Exception{
    
    public UsernameNotFoundException(){
        super("Sorry, Username not found");
    }

    public UsernameNotFoundException(String message){
        super(message);
    }
}
    

