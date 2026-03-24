package com.storeproject.service.product;
import com.storeproject.dto.*;
import com.storeproject.model.*;
import com.storeproject.mapping.ProductMapper;


import java.util.*;


import org.springframework.stereotype.Service;

import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;

import jakarta.transaction.Transactional;;

@Service
public class ProductService {
    
        private final ProductRepository productRepository;
        protected ClothingRepository clothingRepository;
        protected ElectronicsRepository electronicsRepository;
        protected FoodRepository foodRepository;
       
        protected ProductMapper productMapper;


        public ProductService(
             ClothingRepository clothingRepository,
             ElectronicsRepository electronicsRepository,
             FoodRepository foodRepository,
             ProductMapper productMapper, 
             ProductRepository productRepository

           
        ){
            this.clothingRepository = clothingRepository;
            this.electronicsRepository = electronicsRepository;
            this.foodRepository = foodRepository;
            this.productMapper = productMapper;
            this.productRepository = productRepository;
          

        }

        //will need this function later
       
           Boolean validCategory(String category){
            String c1 = "Electronic";
            String c2 = "Food";
            String c3= "Electronic";
            if(c1.equalsIgnoreCase(category) ||
                c2.equalsIgnoreCase(category) ||
                c3.equalsIgnoreCase(category)){
                    return true;
                }
            return false;
        }


        //admin
        public void  addProduct(List<CreatedProduct> req) throws Exception {
            for(CreatedProduct p: req){
                    productRepository.save(productMapper.FromDtoToProduct(p));
             }

        }


      
     


        //customer , hence why we reutrn a dto 
        public CreatedProduct  viewProductById(Long Id) throws Exception{
            
            if(!productRepository.existsById(Id)){
            throw new ProductNotFoundException();

        }

        Product productToBeViewed= productRepository.getReferenceById(Id);

        return productMapper.FromProductToDto(productToBeViewed);
           

        }
    //admin
      public List<CreatedProduct> viewByCategory(String category) throws Exception{
      
         if(!validCategory(category)){
                throw new invalidProductCategoryException();
            }
        

        List<Product> results = new ArrayList<>();
        results.addAll(productRepository.findByCategory(category));

        List<CreatedProduct> productsToBeViewed = new ArrayList<>();

        for(Product p: results){
            productsToBeViewed.add(productMapper.FromProductToDto(p));
        }
        
        return productsToBeViewed;
    }
      
    //admin
        public List<CreatedProduct> viewAllProducts() throws Exception{
            List<Product> results = new ArrayList<>();
            results.addAll(productRepository.findAll());
            
            //if the list if empty
            if(results.isEmpty()){
                    throw new  noProductsFoundException();
            }   

            List<CreatedProduct> allProducts = new ArrayList<>();

            for(Product p: results){
                allProducts.add(productMapper.FromProductToDto(p));
            }
        
         return allProducts;
        }

        //admin
        @Transactional
        public Product  updatedProduct(Long Prod_id,  CreatedProduct req) throws Exception{
         
        if(!productRepository.existsById(Prod_id)){
                throw  new ProductNotFoundException();
            }
        String category  = req.getCategory();

          if(!validCategory(category)){
                throw new invalidProductCategoryException();
            }
        

            //can use getRefencebyid now that im sure its exists, 
            //dont have to access all three repostories if not needed
        Product productToBeUpdated = productRepository.getReferenceById(Prod_id);
           
         return  productRepository.save(productMapper.FromDtoToUpdateProduct(productToBeUpdated, req)); 
            
        }



          //admin
        public void deleteProduct(Long id) throws Exception{

            
            if(productRepository.existsById(id)){
                productRepository.deleteById(id);
                }
          
            
            else{
            throw new ProductNotFoundException();
            }
            
             
        }


}
