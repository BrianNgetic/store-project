package com.storeproject.repository;
import com.storeproject.model.*;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



@DataJpaTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    

    Clothing clothing;
    Electronics electronics;
    Food food;
    FoodNutrition foodNutrition;


    @BeforeEach
    public void setup(){
        //create a  new product
        clothing = new Clothing(
                "North Face Puffer Jacket",
                "clothing",
                "jacket",
                45.0,
                45,
                "M",
                "Blue");

        electronics = new Electronics(   
                    "Samsung Galaxy S23",
                    "electronics",
                    "phone",
                    244,
                    26,
                    true,
                    30,
                    2.0
       );
      foodNutrition = new FoodNutrition(
                159,
                14,
                29,
                13);
        food = new Food(
            "Almond Butter Jar",
            "food",
            "grocery",
            10.09,
            109,
            foodNutrition,
            LocalDate.parse("2026-02-07"   ) 
            );


       
    }

    // @AfterEach
    // public static void tearDown(){
    //     productRepository.deleteAll();

    // }

    @Test
    public void  save_shouldPersistEntity(){
        productRepository.saveAll(List.of(clothing, electronics, food));
        List<Product> allProducts  = productRepository.findAll();

        assertEquals(3, allProducts.size());
    }

    @Test
    public void findById_shouldReturnEntity_whenExistsEmpty_WhenDoesnt(){
        productRepository.save(clothing);

        Optional<Product> optCloth =   productRepository.findById(clothing.getId());
        
        assertAll(
            () ->assertTrue(optCloth.isPresent()),
            () ->assertFalse(optCloth.isEmpty())
        );

    }

    @Test

    public void deleteById_shouldRemoveEntity(){

        productRepository.saveAll(List.of(electronics, food, clothing));
        
      

     

        productRepository.deleteById(food.getId());
        Optional<Product> prodtoBeDeleted = productRepository.findById(food.getId());

        List<Product> updatedAllProducts = productRepository.findAll();
       

        
        assertAll(
            () ->assertEquals(2,  updatedAllProducts.size()),
            () ->assertTrue(prodtoBeDeleted.isEmpty()),
            () ->assertFalse(prodtoBeDeleted.isPresent())
        );
    }

    public void findByCategory_shouldReturnEntities_ifExists(){
         productRepository.saveAll(List.of(electronics, food, clothing));

        List<Product> allElectronicsList = productRepository.findByCategory("electronics");
        List<Product> allFoodList =   productRepository.findByCategory("food");
        List<Product> allClothingsList =  productRepository.findByCategory("clothing");

        assertAll(
            () ->assertEquals(1, allClothingsList.size()),
            () ->assertEquals(1, allFoodList.size()),
            () ->assertEquals(1, allElectronicsList.size())
    

        );  
    }

// 
}
