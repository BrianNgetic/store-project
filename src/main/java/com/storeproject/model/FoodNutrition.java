package com.storeproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
public class FoodNutrition {
   
    
        @Column(name  = "protein", nullable = false)
        int protein;

        @Column(name = "carbs", nullable = false)
        int carbs;
        
        @Column(name = "fat", nullable = false)
        int fat;

        @Column(name = "calories", nullable = false)
        int calories;
        
   public FoodNutrition(
        int protein,
        int carbs, 
        int fat,
        int calories
   ){
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.calories = calories;
   } 

}
