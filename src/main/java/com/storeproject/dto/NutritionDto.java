package com.storeproject.dto;

import lombok.*;


@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NutritionDto{
   private  int protein;
   private  int carbs;
   private  int fat;
   private  int calories;


}