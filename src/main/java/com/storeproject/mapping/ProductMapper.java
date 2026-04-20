package com.storeproject.mapping;

import java.util.*;

import org.springframework.stereotype.Component;
import com.storeproject.model.*;
import com.storeproject.dto.*;
import com.storeproject.Exceptions.*;;

@Component
public class ProductMapper {
//create
    public Product FromDtoToProduct(CreatedProduct createdProduct) throws RuntimeException {

        String DTOcategory = createdProduct.getCategory();

        switch (DTOcategory) {
            case "Electronic":
                ElectronicResponseDTO edto = (ElectronicResponseDTO) createdProduct;

                Electronics e = new Electronics();
                e.setName(edto.getName());
                e.setCategory("Electronic");
                e.setPrice(edto.getPrice());
                e.setStock(edto.getStock());
                e.setType(edto.getType());
                e.setWarrantyElible(edto.getWarrantyEligible());
                e.setWarrantyPeriod(edto.getWarrantyPeriod());
                e.setProductVersion(edto.getProductVersion());
                e.setWarrantyPeriod(edto.getWarrantyPeriod());
                e.setProductVersion(edto.getProductVersion());
                return e;

            case "Food":
                 FoodResponseDTO fdto = (FoodResponseDTO) createdProduct;

                Food f = new Food();
                f.setName(fdto.getName());
                f.setCategory("Food");
                f.setType(fdto.getType());
                f.setPrice(fdto.getPrice());
                f.setStock(fdto.getStock());
                f.setExpirationDate(fdto.getExpiryDate());
                NutritionDto dto = fdto.getFoodNutrition();
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
             ClothingResponseDTO cdto = (ClothingResponseDTO) createdProduct;

                Clothing c = new Clothing();
                c.setName(cdto.getName());
                c.setCategory("Food");
                c.setPrice(cdto.getPrice());
                c.setStock(cdto.getStock());
                c.setType(cdto.getType());
                c.setSize(cdto.getClothSize());
                c.setColor(cdto.getClothColor());
                return c;
            default:
                throw new invalidProductCategoryException();

        }
    }


//forUpdating

    public Product FromDtoToUpdateProduct(Product product, UpdateProductDto updateProductDto) throws RuntimeException {

        if(updateProductDto.getName() != null){
            product.setName(updateProductDto.getName());
        }

        if(updateProductDto.getPrice() != null){
            product.setPrice(updateProductDto.getPrice());
    
        }

        if(updateProductDto.getStock() != null){
            product.setStock(updateProductDto.getStock());
        }

        return product;
    }



    public CreatedProduct FromProductToDto(Product product) throws RuntimeException {

        String category = product.getCategory();

        switch (category) {
            case "Electronic":
                Electronics electronic = (Electronics) product;
                return ElectronicResponseDTO.builder()
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

                    return FoodResponseDTO.builder()
                            .name(food.getName())
                            .category(food.getCategory())
                            .type(food.getType())
                            .price(food.getPrice())
                            .expiryDate(food.getExpirationDate())
                            .foodNutrition(tempFoodNutrion)
                            .build();

            case "Clothing":
                Clothing clothing = (Clothing)product;

                
                return ClothingResponseDTO.builder().name(clothing.getName())
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