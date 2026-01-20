package com.storeproject.service.product;
import com.storeproject.dto.*;
import com.storeproject.model.*;
import com.storeproject.model.Exceptions.ProductNotFoundException;

import java.util.*;

import org.springframework.stereotype.Service;

import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;;

@Service
public class ProductService {
    
        protected ClothingRepository clothingRepository;
        protected ElectronicsRepository electronicsRepository;
        protected FoodRepository foodRepository;
       


        public ProductService(
             ClothingRepository clothingRepository,
             ElectronicsRepository electronicsRepository,
             FoodRepository foodRepository
           
        ){
            this.clothingRepository = clothingRepository;
            this.electronicsRepository = electronicsRepository;
            this.foodRepository = foodRepository;
          

        }

        

        public Product addProduct(CreatedProduct req) throws Exception {
            String prod_category = req.getCategory();
            switch(prod_category){
                case "Electronic":
                    Electronics e = new Electronics();
                    e.setName(req.getName());
                    e.setCategory(prod_category);
                    e.setPrice(req.getPrice());
                    e.setStock(req.getStock());
                    e.setWarrantyElible(req.getWarrantyEligible());
                    e.setWarrantyPeriod(req.getWarrantyPeriod());
                    e.setProductVersion(req.getProductVersion());
                    e.setWarrantyPeriod(req.getWarrantyPeriod());
                    e.setProduct_type(req.getProductType());
                    e.setProductVersion(req.getProductVersion());
                    return  electronicsRepository.save(e);
                case "Food":
                    Food f = new Food();
                    f.setName(req.getName());
                    f.setCategory(prod_category);
                    f.setPrice(req.getPrice());
                    f.setStock(req.getStock());
                    f.setExpirationDate(req.getExpiryDate());
                    NutritionDto dto  = req.getNutrition();
                    if(dto == null) throw new  noNutritionInfoGiven();
                    else{
                    FoodNutrition nutrition = new FoodNutrition();
                    nutrition.setProtein(dto.getProtein());
                    nutrition.setCarbs(dto.getCarbs());
                    nutrition.setFat(dto.getFat());
                    nutrition.setCalories(dto.getCalories());
                    }
                    return foodRepository.save(f);
                case "Clothing":
                    Clothing c = new Clothing();
                    c.setCategory(prod_category);
                    c.setPrice(req.getPrice());
                    c.setStock(req.getPrice());
                    c.setType(req.getClothType());
                    c.setSize(req.getClothSize());
                    c.setColor(req.getClothColor());
                     return   clothingRepository.save(c);
                    
                default:
                    throw new invalidProductCategory();

           }


        }

        public void deleteProduct(Long id) throws Exception{
                if (electronicsRepository.existsById(id)) {
                     electronicsRepository.deleteById(id);
                         return;
                 }

                 if (foodRepository.existsById(id)) {
                         foodRepository.deleteById(id);
                      return;
                     }

                if (clothingRepository.existsById(id)) {
                         clothingRepository.deleteById(id);
                    return;
                }

            throw new ProductNotFoundException();
             
        }

        //do update product in a second
        public Product  updatedProduct(Long Prod_id,  CreatedProduct req) throws Exception{
            String Category = req.getCategory();

            switch(Category){
                case "Electronic":
                    Electronics e  =  electronicsRepository.findById(Prod_id)
                                    .orElseThrow(productNotFoundException::new);
                    e.setId(Prod_id);
                    e.setName(req.getName());
                    e.setPrice(req.getPrice());
                    e.setStock(req.getStock());
                    e.setWarrantyElible(req.getWarrantyEligible());
                    e.setWarrantyPeriod(req.getWarrantyPeriod());
                    e.setProductVersion(req.getProductVersion());
                    e.setProduct_type(req.getProductType());
                   return  electronicsRepository.save(e);
                    
                case "Clothing":    
                    Clothing c = clothingRepository.findById(Prod_id).orElseThrow(productNotFoundException::new);
                    c.setId(Prod_id);
                    
                    c.setPrice(req.getPrice());
                    c.setStock(req.getStock());
                    c.setType(req.getProductType());
                    c.setSize(req.getClothSize());
                    c.setColor(req.getClothColor());
                    return clothingRepository.save(c);
                  

                case "Food":
                    Food f = foodRepository.findById(Prod_id).orElseThrow(productNotFoundException::new);
                    f.setId(Prod_id);
                    f.setName(req.getName());
                    f.setPrice(req.getPrice());
                    f.setStock(req.getStock());
                    NutritionDto dto = req.getNutrition();
                    if(dto == null) throw new noNutritionInfoException();
                    FoodNutrition nutrition = new FoodNutrition();
                     nutrition.setProtein(dto.getProtein());
                     nutrition.setCarbs(dto.getCarbs());
                     nutrition.setFat(dto.getFat());
                     nutrition.setCalories(dto.getCalories());
                     f.setFoodNutrition(nutrition);
                     return foodRepository.save(f);
                    
                default:
                    throw new  invalidProductCategory();
            }

        }

        public Product viewProductById(Long Id) throws Exception{

            Optional<Electronics> electronics  = electronicsRepository.findById(Id);
            if(electronics.isPresent()){ return electronics.get();}

             Optional<Clothing> clothing  = clothingRepository.findById(Id);
            if(clothing.isPresent()){ return clothing.get();}


            Optional<Food> food  = foodRepository.findById(Id);
            if(food.isPresent()){ return food.get();}

        
            throw new productNotFoundException();
        }

      public List<Product> viewByCategory(String category) throws Exception{
            List<Product> results = new ArrayList<>();
            switch(category){
                case "Food":
                    results.addAll(foodRepository.findAll());
                    break;
                case "Electronic":
                    results.addAll(electronicsRepository.findAll());
                    break;
                case "Clothing":
                    results.addAll(clothingRepository.findAll());
                    break;
                default:
                    throw new  invalidProductCategory();
            }
           
             return results;
    }


        public List<Product> viewAllProducts(){
            List<Product> results = new ArrayList<>();
            results.addAll(electronicsRepository.findAll());
            results.addAll(foodRepository.findAll());
            results.addAll(clothingRepository.findAll());
     return results;
        }

}
