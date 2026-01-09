package com.storeproject.model;

import java.time.*;

import jakarta.persistence.Embeddable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Food  extends Product{
    
    //variables
    @Column(name = "expiry_date")
    LocalDate expirationDate;


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
    // boolean  isExpired(){

    //     return true; ///to be added to service
    // }
    
    // // String getexpirationDate(){
   

    // // }

    // @Override
    // // void applydiscount() {
    // //     // TODO
      
    // // }

    // // @Override
    // // void updatestock() {
    // //     // TODO

    // // }

    // // @Override
    // // double calcTotal() {
    // //     // TODO
    // //     return total;
    // // }

 
    
}
