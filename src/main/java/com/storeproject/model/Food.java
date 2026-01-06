package com.storeproject.model;

import java.time.*;

import jakarta.persistence.Embeddable;
import jakarta.persistence.*;

public class Food  extends Product{
    
    //variables
    @Column(name = "expiry_date")
    LocalDate expirationDate;

    @Override
    public boolean isInStock() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void validate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Embeddable
    class Nutrition{
        @Column(name  = "protein")
        int protein;

        @Column(name = "carbs")
        int carbs;
        
        @Column(name = "fat")
        int fat;

        @Column(name = "calories")
        double calories ;
    }

                //functions
    //mutators
   // nutrutition accessor and modifier fuction to be added soon

    


    //accessors
    boolean  isExpired(){

        return true; ///to be changed
    }
    
    // String getexpirationDate(){
   

    // }

    Nutrition getnutritionInfo(){ // to be changed

        return null ;
    }


    // @Override
    // void applydiscount() {
    //     // TODO
      
    // }

    // @Override
    // void updatestock() {
    //     // TODO

    // }

    // @Override
    // double calcTotal() {
    //     // TODO
    //     return total;
    // }

 
    String getname() {
        // TODO
        return name; 
    }

  
    double getprice() {
        // TODO
        return price;
    }


    int getstock() {
        // TODO
        return stock;
    }
}
