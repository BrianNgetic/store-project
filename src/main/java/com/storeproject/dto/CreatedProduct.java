package com.storeproject.dto;

// import com.storeproject.model.*;
// import com.storeproject.model.FoodNutrition;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CreatedProduct {

    // common
   
    private String name;
    private String category;
    private String type;
    private int price;
    private int stock;

    // food (optional)
    private LocalDate expiryDate;
    private NutritionDto foodNutrition;

    // nutrition can be another object and be null

    // electronics (optional)
    private Boolean warrantyEligible;
    private Integer warrantyPeriod;
    private Double productVersion;
    private Integer updatedProductVersion;

    // clothing (optional)
    
    private String clothSize;
    private String clothColor;
  
    // getters & setters
}
