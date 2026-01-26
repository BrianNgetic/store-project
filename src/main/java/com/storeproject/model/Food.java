package com.storeproject.model;

import java.time.*;

import jakarta.persistence.*;
import lombok.*;
// import com.storeproject.model.FoodNutrition;
//same "folder" so i dont have to import it


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Food  extends Product{
   
    
   
    @Embedded
    @NonNull
    private   FoodNutrition foodNutrition;

    //variables
    @Column(name = "expiryDate")
    LocalDate expirationDate;


    @Override
    public void validate() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // 
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
