package com.storeproject.Exceptions;

import java.net.ResponseCache;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.storeproject.Exceptions.*;
import com.storeproject.model.ErrorDetails;
@ControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(invalidProductCategoryException.class)
    public ResponseEntity<?> handleInvalidCategoryException(invalidProductCategoryException e, 
    WebRequest request){

        ErrorDetails errorDetails = new ErrorDetails(
            HttpStatus.BAD_REQUEST.value(),
            e.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException e, 
    WebRequest request){

         ErrorDetails errorDetails = new ErrorDetails(
            HttpStatus.NOT_FOUND.value(),
            e.getMessage(),
            request.getDescription(false)
        );


        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        
    }


    



}
