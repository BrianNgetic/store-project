package com.storeproject.service;

import com.storeproject.model.Product;
import com.storeproject.repository.ProductRepository;
// import java.util.*;
// import org.springframework.stereotype.Service; //for service
// import org.springframework.beans.factory.annotation.*; //for autowired 
// import org.springframework.beans.BeanUtils; //to beanutils



public class UpdateProductServiceInterfaceImplementation implements UpdateProductServiceInterface
{


    private final ProductRepository productRepository;

    public UpdateProductServiceInterfaceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }



     
@Override
 public Product UpdateProduct(Long Prod_id, Product updatedProduct ){
        
    
       Product existingProduct = productRepository.findById(Prod_id)
        .orElseThrow(() -> new RuntimeException("Product not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());

productRepository.save(existingProduct);
        return  productRepository.save(existingProduct);
 }

}

