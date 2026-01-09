package com.storeproject.service.product;

import com.storeproject.model.Product;
import com.storeproject.repository.*;

// import java.util.*;
import org.springframework.stereotype.Service; //for service
// import org.springframework.beans.factory.annotation.*; //for autowired 


@Service
public class AddProductServiceInterfaceImplementation implements AddProductServiceInterface{

       
       
        final  ProductRepository productRepository;

        //@Autowired //apparently its unnecesary because its the only constructor anyway
        public  AddProductServiceInterfaceImplementation( ProductRepository productRepository){
                this.productRepository = productRepository;
        }


          public  Product addProduct( Product newaddedproduct){
                 return  productRepository.save(newaddedproduct);
       
      }
}
 
