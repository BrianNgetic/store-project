package com.storeproject.dto;

// import com.storeproject.model.*;
// import com.storeproject.model.FoodNutrition;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CreatedProduct {

    // common
    @NotBlank
    private String name;
    
    @NotBlank
    private String category;

    @NotBlank
    private String type;

    @NotBlank
    @Positive
    private Double price;

    @PositiveOrZero
    private Integer stock;



    // getters & setters
}
