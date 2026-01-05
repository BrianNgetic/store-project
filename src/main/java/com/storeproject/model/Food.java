package src.main.java.com.storeproject.model;

import java.io.*;
import java.lang.*;
// import users.string;
import java.time.*;

import jakarta.persistence.Embeddable;

public class Food  extends Product{
    
    //variables
    @Column(name = "expiry_date")
    LocalDate expirationDate;

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
    
    String getexpirationDate(){
   

    }

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

    @Override
    String getname() {
        // TODO
        return name; 
    }

    @Override
    double getprice() {
        // TODO
        return price;
    }

    @Override
    int getstock() {
        // TODO
        return stock;
    }
}
