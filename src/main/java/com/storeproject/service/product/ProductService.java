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

        

        public void  addProduct(List<CreatedProduct> req) throws Exception {
            for(CreatedProduct p: req){
            String prod_category = p.getCategory();
            switch(prod_category){
                case "electronics":
                    Electronics e = new Electronics();
                    e.setName(p.getName());
                    e.setCategory(prod_category);
                    e.setPrice(p.getPrice());
                    e.setStock(p.getStock());
                    e.setType(p.getType());
                    e.setWarrantyElible(p.getWarrantyEligible());
                    e.setWarrantyPeriod(p.getWarrantyPeriod());
                    e.setProductVersion(p.getProductVersion());
                    e.setWarrantyPeriod(p.getWarrantyPeriod());
                    // e.setProduct_type(p.getProductType());
                    e.setProductVersion(p.getProductVersion());
                     electronicsRepository.save(e);
                     break;
                case "food":
                    Food f = new Food();
                    f.setName(p.getName());
                    f.setCategory(prod_category);
                    f.setType(p.getType());
                    f.setPrice(p.getPrice());
                    f.setStock(p.getStock());
                    f.setExpirationDate(p.getExpiryDate());
                    NutritionDto dto  = p.getFoodNutrition();
                    if(dto == null) throw new  noNutritionInfoGiven();
                    else{
                    FoodNutrition nutrition = new FoodNutrition();
                    nutrition.setProtein(dto.getProtein());
                    nutrition.setCarbs(dto.getCarbs());
                    nutrition.setFat(dto.getFat());
                    nutrition.setCalories(dto.getCalories());
                    f.setFoodNutrition(nutrition);
                    }
                    
                    foodRepository.save(f);
                    break;
                case "clothing":
                    Clothing c = new Clothing();
                    c.setName(p.getName());
                    c.setCategory(prod_category);
                    c.setPrice(p.getPrice());
                    c.setStock(p.getPrice());
                    c.setType(p.getType());
                    c.setSize(p.getClothSize());
                    c.setColor(p.getClothColor());
                      clothingRepository.save(c);
                      break;
                    
                default:
                    throw new invalidProductCategory();

           }
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
                    // e.setProductType(req.getProductType());
                   return  electronicsRepository.save(e);
                    
                case "Clothing":    
                    Clothing c = clothingRepository.findById(Prod_id).orElseThrow(productNotFoundException::new);
                    c.setId(Prod_id);
                    
                    c.setPrice(req.getPrice());
                    c.setStock(req.getStock());
                    c.setType(req.getType());
                    c.setSize(req.getClothSize());
                    c.setColor(req.getClothColor());
                    return clothingRepository.save(c);
                  

                case "Food":
                    Food f = foodRepository.findById(Prod_id).orElseThrow(productNotFoundException::new);
                    f.setId(Prod_id);
                    f.setName(req.getName());
                    f.setType(req.getType());
                    f.setPrice(req.getPrice());
                    f.setStock(req.getStock());
                    f.setExpirationDate(req.getExpiryDate());

                    NutritionDto dto = req.getFoodNutrition();
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
