package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository; //for jparepository
import org.springframework.stereotype.Repository; //for repository
import jakarta.persistence.*; //for the  columns  stuff
import com.storeproject.model.Product; //for the entity

@Repository
public class userRepository implements JpaRepository<Product, Long>{
    
}
