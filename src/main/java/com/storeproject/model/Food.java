package com.storeproject.model;

import java.time.*;

import org.springframework.cglib.core.Local;

import jakarta.persistence.*;
import lombok.*;
// import com.storeproject.model.FoodNutrition;
//same "folder" so i dont have to import it


@Entity
@Setter
@Getter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "prodId")
public class Food  extends Product{
   
    
   
    @Embedded
    @NonNull
    private   FoodNutrition foodNutrition;

    //variables
    @Column(name = "expiryDate")
    LocalDate expirationDate;


    public Food(
        String name,
        String category, 
        String type, 
        double price, 
        int stock, 
        FoodNutrition foodNutrition,
        LocalDate exprirationDate
       ){

            this.name = name;
            this.category =  category;
            this.type = type;
            this.price = price;
            this.stock  = stock;
            this.foodNutrition = foodNutrition;
            this.expirationDate = exprirationDate;
    }
    @Override
    public void validate() {
    //     throw new UnsupportedOperationException("Not supported yet.");
    // 
    }



 
 
    
}
