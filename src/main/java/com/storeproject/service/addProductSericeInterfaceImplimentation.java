package com.storeproject.service;

import com.storeproject.model.Product;
import com.storeproject.repository.*;
import java.util.*;
import org.springframework.stereotype.Service; //for service
import org.springframework.beans.factory.annotation.*; //for autowired 


@Service
public class addProductSericeInterfaceImplimentation implements addProductServiceInterface{

       
        private  ProductRepository productRepository;

        @AutoWired
        public  addProductSericeInterfaceImplimentation( ProductRepository productRepository){
                this.ProductRepository = productRepository;
        }

        
        @Override
          public   List<Product> addProduct(){
         return  productRepository.save();
      }
 }
 
