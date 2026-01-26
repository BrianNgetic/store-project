package com.storeproject.controller;

// import java.net.ResponseCache;

import org.springframework.http.ResponseEntity;

// import java.net.ResponseCache;
import java.util.*;

// import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.storeproject.dto.CreatedProduct;
import com.storeproject.model.*;
import com.storeproject.service.product.*;
// import com.storeproject.service.product.AddProductServiceInterfaceImplementation;
// import com.storeproject.service.product.DeleteProductServiceInterfaceImplementation;
// import com.storeproject.service.product.UpdateProductServiceInterfaceImplementation;
// import com.storeproject.service.product.ViewProductServiceInterfaceImplementation;

// import jakarta.ws.rs.Path;

// import com.storeproject.service.*;



@RestController //indicated this class handled web requests
@RequestMapping("/product") //maps all the  incoming requests to their handler methods
public class ProductController { 

    
    public final ProductService productService;
    public ProductController(ProductService  productService){
        this.productService = productService;
        
        }
    @PostMapping("/add-product") //create and add a product
    public ResponseEntity<?> CreateProduct(@RequestBody List<CreatedProduct>  product) throws Exception{
        //requestbody converts the http request body to java objects that we can use


         productService.addProduct(product);
   
         return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/update-product/{id}") //update a product
    public ResponseEntity<?> UpdateProduct(@PathVariable Long id, @RequestBody CreatedProduct product){
                //pathvariable binds the requested paremeter of the handler method to the url making it dynamic 
            try{
            productService.updatedProduct(id, product);
            }catch(Exception e){
                e.printStackTrace();
            }

          return ResponseEntity.status(HttpStatus.CREATED).body(product);


    
    }
    @GetMapping("/id/{id}") // get requests
    public ResponseEntity<Product> viewById(@PathVariable Long id) throws Exception{

      
      return ResponseEntity.ok(productService.viewProductById(id));
    }


    @GetMapping("/category/{category}") //view by category
    public ResponseEntity<List<Product>> viewByCategory(@PathVariable String category) throws Exception{
             return ResponseEntity.ok(productService.viewByCategory(category));
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> viewAllProducts(){
           return ResponseEntity.ok(productService.viewAllProducts());
    }

    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<String> deleteProduct( @PathVariable Long id) {
      try{
             productService.deleteProduct(id);
      }
      catch(Exception e){
        e.printStackTrace();
      }
        return ResponseEntity.ok("Succesfully Deleted product with id"  + id);
    }





}