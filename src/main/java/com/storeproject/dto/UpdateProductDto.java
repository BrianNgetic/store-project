package com.storeproject.dto;

import java.time.LocalDate;
import lombok.*;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDto {

    // common
   
    private String name;
    private String category;
    private String type;
    private Double price;
    private Integer stock;
    

    //electronic
    private Boolean warrantyEligible;
    private Integer warrantyPeriod;
    private Double productVersion;
    private Integer updatedProductVersion;

    //food

    private LocalDate expiryDate;
    private NutritionDto foodNutrition;

    //clothing

    
    private String clothSize;
    private String clothColor;

}
