package com.storeproject.controller;

// import java.net.ResponseCache;

import org.springframework.http.ResponseEntity;

import java.net.ResponseCache;
import java.util.*;

import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.storeproject.model.*;
import com.storeproject.service.AddProductServiceInterfaceImplementation;
import com.storeproject.service.DeleteProductServiceInterfaceImplementation;
import com.storeproject.service.UpdateProductServiceInterfaceImplementation;
import com.storeproject.service.ViewProductServiceInterfaceImplimentation;

// import jakarta.ws.rs.Path;

// import com.storeproject.service.*;



@RestController //indicated this class handled web requests
@RequestMapping("/product") //maps all the  incomgin requests to their handler methods
public class ProductController { 

    
    private final  AddProductServiceInterfaceImplementation addProductServiceInterfaceImplementation;
    private final  DeleteProductServiceInterfaceImplementation deleteProductServiceInterfaceImplementation;
    private final  UpdateProductServiceInterfaceImplementation  updateProductServiceInterfaceImplementation;
    private final ViewProductServiceInterfaceImplimentation viewProductServiceInterfaceImplimentation;

    public ProductController(
        AddProductServiceInterfaceImplementation addProductServiceInterfaceImplementation,
        DeleteProductServiceInterfaceImplementation deleteProductServiceInterfaceImplementation,
        UpdateProductServiceInterfaceImplementation updateProductServiceInterfaceImplementation,
        ViewProductServiceInterfaceImplimentation veiwProductServiceInterfaceImplimentation){
            this.addProductServiceInterfaceImplementation = addProductServiceInterfaceImplementation;
            this.deleteProductServiceInterfaceImplementation = deleteProductServiceInterfaceImplementation;
            this.updateProductServiceInterfaceImplementation =  updateProductServiceInterfaceImplementation;        
            this.viewProductServiceInterfaceImplimentation = veiwProductServiceInterfaceImplimentation;
        }
    @PostMapping("/add-product") //create and add a product
    public ResponseEntity<?> CreateProduct(@RequestBody Product product){
        //requestbody convets the http request body to java objects that we can use

    
         addProductServiceInterfaceImplementation.addProduct(product);
         return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/update-product/{id}") //update a product
    public ResponseEntity<?> UpdateProduct(@PathVariable Long id, @RequestBody Product product){
                //pathvariable binds the requested paremeter of the handler method to the url making it dynamic 

          updateProductServiceInterfaceImplementation.UpdateProduct(id, product);

          return ResponseEntity.status(HttpStatus.CREATED).body(product);


    
    }
    @GetMapping("/product/{id}") // get requests
    public ResponseEntity<Product> viewById(Long id){


        return ResponseEntity.ok(viewProductServiceInterfaceImplimentation.viewById(id));
    
    }


    @GetMapping("/product/{category}") //view by category
    public ResponseEntity<List<Product>> viewByCategory(String category){
             return ResponseEntity.ok(viewProductServiceInterfaceImplimentation.viewByCategory(category));
    }

    @GetMapping("/products/allProducts")
    public ResponseEntity<List<Product>> viewAllProducts(){
           return ResponseEntity.ok(viewProductServiceInterfaceImplimentation.viewAllProducts());
    }

    @DeleteMapping("/products-product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        deleteProductServiceInterfaceImplementation.deleteProduct(id);
        return ResponseEntity.ok("Succesfully Deleted product with id"  + id);
    }





}