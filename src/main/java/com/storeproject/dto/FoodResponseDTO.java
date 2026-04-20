package com.storeproject.dto;


import java.time.LocalDate;
import lombok.*;
import lombok.experimental.SuperBuilder;




@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseDTO extends CreatedProduct{
       
   
    private LocalDate expiryDate;
    private NutritionDto foodNutrition;

}