package com.storeproject.service.product;

import com.storeproject.model.Product;
import com.storeproject.repository.ProductRepository;
// import com.storeproject.repository.UserRepository;

import java.util.*;

public class ViewProductServiceInterfaceImplementation implements ViewProductServiceInterface {


    private final  ProductRepository productRepository;

    public ViewProductServiceInterfaceImplementation(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product viewById(Long id) {

        return productRepository.getReferenceById(id);
    }

    @Override
    public List<Product> viewByCategory(String category) {
      return   productRepository.findByCategory(category);
    }

    @Override
    public List<Product> viewAllProducts() {
        return productRepository.findAll();
    }
    }
    

