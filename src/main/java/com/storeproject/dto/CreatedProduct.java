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
    private String category;
    private String name;
    private int price;
    private int stock;

    // food (optional)
    private LocalDate expiryDate;
    private NutritionDto nutrition;

    // nutrition can be another object and be null

    // electronics (optional)
    private Boolean warrantyEligible;
    private Integer warrantyPeriod;
    private Double productVersion;
    private String productType;
    private Integer updatedProductVersion;

    // clothing (optional)
    private String clothType;
    private String clothSize;
    private String clothColor;
  
    // getters & setters
}
