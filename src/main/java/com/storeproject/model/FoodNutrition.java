package com.storeproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class FoodNutrition {
   
    
        @Column(name  = "protein", nullable = false)
        int protein;

        @Column(name = "carbs", nullable = false)
        int carbs;
        
        @Column(name = "fat", nullable = false)
        int fat;

        @Column(name = "calories", nullable = false)
        int calories  = (protein * 4) + (carbs * 4) + (fat * 9);
        
    

}
