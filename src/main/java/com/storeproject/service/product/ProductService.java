package com.storeproject.service.product;
import com.storeproject.dto.*;
import com.storeproject.model.*;

import java.util.*;

import org.springframework.stereotype.Service;

import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;;

@Service
public class ProductService {
    
        protected ClothingRepository clothingRepository;
        protected ElectronicsRepository electronicsRepository;
        protected FoodRepository foodRepository;
        protected ProductRepository productRepository;


        public ProductService(
             ClothingRepository clothingRepository,
             ElectronicsRepository electronicsRepository,
             FoodRepository foodRepository,
             ProductRepository productRepository
        ){
            this.clothingRepository = clothingRepository;
            this.electronicsRepository = electronicsRepository;
            this.foodRepository = foodRepository;
            this.productRepository = productRepository;

        }

        

        public void addProduct(CreatedProduct req) throws Exception {
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
                    electronicsRepository.save(e);
                    break;
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
                    break;
                case "Clothing":
                    Clothing c = new Clothing();
                    c.setCategory(prod_category);
                    c.setName(req.getName());
                    c.setPrice(req.getPrice());
                    c.setStock(req.getPrice());
                    c.setType(req.getClothType());
                    c.setSize(req.getClothSize());
                    c.setColor(req.getClothColor());
                    clothingRepository.save(c);
                    break;
                default:
                    throw new invalidProductCategory();

           }


        }

        public void deleteProduct(CreatedProduct req, Long id) throws Exception{
               String category = req.getCategory();
               switch(category){
                    case "Electronic":
                        electronicsRepository.deleteById(id);
                        break;
                    case "Food":
                        foodRepository.deleteById(id);
                        break;
                    case "Clothing":
                        clothingRepository.deleteById(id);
                        break;
                    default:
                        throw new  invalidProductCategory();
         }       
        }

        //do update product in a second
        public void  updatedProduct(Long Prod_id,  CreatedProduct req) throws Exception{
            String Category = req.getCategory();

            switch(Category){
                case "Electronic":
                    Electronics e  = new Electronics();
                    e.setId(Prod_id);
                    e.setName(req.getName());
                    e.setPrice(req.getPrice());
                    e.setStock(req.getStock());
                    e.setWarrantyElible(req.getWarrantyEligible());
                    e.setWarrantyPeriod(req.getWarrantyPeriod());
                    e.setProductVersion(req.getProductVersion());
                    e.setProduct_type(req.getProductType());
                    electronicsRepository.save(e);
                    break;
                case "clothing":    
                    Clothing c = new Clothing();
                    c.setId(Prod_id);
                     c.setName(req.getName());
                    c.setPrice(req.getPrice());
                    c.setStock(req.getStock());
                    c.setType(req.getProductType());
                    c.setSize(req.getClothSize());
                    c.setColor(req.getClothColor());
                    clothingRepository.save(c);
                    break;

                case "Food":
                    Food f = new Food();
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
                     foodRepository.save(f);
                     break;
                default:
                    throw new  invalidProductCategory();
            }

        }

        public Product viewProductById(Long Id){
            return productRepository.getReferenceById(Id);
        }

        public List<Product> viewByCategory(String category){
            return productRepository.findByCategory(category);
        }

        public List<Product> viewAllProducts(){
            return productRepository.findAll();
        }

}
