package com.storeproject.service;
// import com.storeproject.model.Product;
import com.storeproject.repository.*;
// import java.util.*;
import org.springframework.stereotype.Service; //for service
// import org.springframework.beans.factory.annotation.*; //for autowired 

@Service
public class DeleteProductServiceInterfaceImplementation  implements DeleteProductServiceInterface{
    
   
        
    private final  ProductRepository productRepository;

    public DeleteProductServiceInterfaceImplementation(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void  deleteProduct(Long id){
         productRepository.deleteById(id);
     }

    // public void  deleteUser(Long id){
    // Optional <Product> tobeDeleted = productRepository.findById(Id);
    // }


    

}
