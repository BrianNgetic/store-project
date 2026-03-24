package com.storeproject.mapping;

import java.util.*;

import org.springframework.stereotype.Component;
import com.storeproject.model.*;
import com.storeproject.dto.*;
import com.storeproject.Exceptions.*;;

@Component
public class ProductMapper {
//create
    public Product FromDtoToProduct(CreatedProduct createdProduct) throws Exception {

        String DTOcategory = createdProduct.getCategory();

        switch (DTOcategory) {
            case "Electronic":
                Electronics e = new Electronics();
                e.setName(createdProduct.getName());
                e.setCategory("Electronic");
                e.setPrice(createdProduct.getPrice());
                e.setStock(createdProduct.getStock());
                e.setType(createdProduct.getType());
                e.setWarrantyElible(createdProduct.getWarrantyEligible());
                e.setWarrantyPeriod(createdProduct.getWarrantyPeriod());
                e.setProductVersion(createdProduct.getProductVersion());
                e.setWarrantyPeriod(createdProduct.getWarrantyPeriod());
                e.setProductVersion(createdProduct.getProductVersion());
                return e;

            case "Food":
                Food f = new Food();
                f.setName(createdProduct.getName());
                f.setCategory("food");
                f.setType(createdProduct.getType());
                f.setPrice(createdProduct.getPrice());
                f.setStock(createdProduct.getStock());
                f.setExpirationDate(createdProduct.getExpiryDate());
                NutritionDto dto = createdProduct.getFoodNutrition();
                if (dto == null)
                    throw new noNutritionInfoGiven();
                else {
                    FoodNutrition nutrition = new FoodNutrition();
                    nutrition.setProtein(dto.getProtein());
                    nutrition.setCarbs(dto.getCarbs());
                    nutrition.setFat(dto.getFat());
                    nutrition.setCalories(dto.getCalories());
                    f.setFoodNutrition(nutrition);
                }
                return f;

            case "Clothing":
                Clothing c = new Clothing();
                c.setName(createdProduct.getName());
                c.setCategory("Food");
                c.setPrice(createdProduct.getPrice());
                c.setStock(createdProduct.getStock());
                c.setType(createdProduct.getType());
                c.setSize(createdProduct.getClothSize());
                c.setColor(createdProduct.getClothColor());
                return c;
            default:
                throw new invalidProductCategoryException();

        }
    }


//forUpdating
    public Product FromDtoToUpdateProduct(Product product, CreatedProduct createdProduct) throws Exception {

        String prodCategory = product.getCategory();

        switch (prodCategory) {
            case "Electronic":
                Electronics e = (Electronics) product;
                e.setName(createdProduct.getName());
                e.setCategory("Electronic");
                e.setPrice(createdProduct.getPrice());
                e.setStock(createdProduct.getStock());
                e.setType(createdProduct.getType());
                e.setWarrantyElible(createdProduct.getWarrantyEligible());
                e.setWarrantyPeriod(createdProduct.getWarrantyPeriod());
                e.setProductVersion(createdProduct.getProductVersion());
                e.setWarrantyPeriod(createdProduct.getWarrantyPeriod());
                e.setProductVersion(createdProduct.getProductVersion());
                return e;

            case "Food":
                Food f = (Food)product ;
                f.setName(createdProduct.getName());
                f.setCategory("food");
                f.setType(createdProduct.getType());
                f.setPrice(createdProduct.getPrice());
                f.setStock(createdProduct.getStock());
                f.setExpirationDate(createdProduct.getExpiryDate());
                NutritionDto dto = createdProduct.getFoodNutrition();
                if (dto == null)
                    throw new noNutritionInfoGiven();
                else {
                    FoodNutrition nutrition = new FoodNutrition();
                    nutrition.setProtein(dto.getProtein());
                    nutrition.setCarbs(dto.getCarbs());
                    nutrition.setFat(dto.getFat());
                    nutrition.setCalories(dto.getCalories());
                    f.setFoodNutrition(nutrition);
                }
                return f;

            case "Clothing":
                Clothing c =  (Clothing)product;
                c.setName(createdProduct.getName());
                c.setCategory("Food");
                c.setPrice(createdProduct.getPrice());
                c.setStock(createdProduct.getStock());
                c.setType(createdProduct.getType());
                c.setSize(createdProduct.getClothSize());
                c.setColor(createdProduct.getClothColor());
                return c;
            default:
                throw new invalidProductCategoryException();

        }
    }



    public CreatedProduct FromProductToDto(Product product) throws Exception {

        String category = product.getCategory();

        switch (category) {
            case "Electronic":
                Electronics electronic = (Electronics) product;
                return CreatedProduct.builder()
                        .name(electronic.getName())
                        .category(electronic.getCategory())
                        .type(electronic.getType())
                        .price(electronic.getPrice())
                        .warrantyEligible(electronic.isWarrantyElible())
                        .productVersion(electronic.getProductVersion())
                        .build();
               
            case "Food":
                Food food = (Food) product;
                
                    NutritionDto tempFoodNutrion = NutritionDto.builder()
                            .protein(food.getFoodNutrition().getProtein())
                            .carbs(food.getFoodNutrition().getCarbs())
                            .fat(food.getFoodNutrition().getFat())
                            .calories(food.getFoodNutrition().getCalories())
                            .build();

                    return CreatedProduct.builder()
                            .name(food.getName())
                            .category(food.getCategory())
                            .type(food.getType())
                            .price(food.getPrice())
                            .expiryDate(food.getExpirationDate())
                            .foodNutrition(tempFoodNutrion)
                            .build();

            case "Clothing":
                Clothing clothing = (Clothing)product;

                
                return CreatedProduct.builder().name(clothing.getName())
                        .category(clothing.getCategory())
                        .type(clothing.getType())
                        .price(clothing.getPrice())
                        .clothSize(clothing.getSize())
                        .clothColor(clothing.getColor())
                        .build();


            default:
                throw new invalidProductCategoryException();



        }

        
    }

   
}