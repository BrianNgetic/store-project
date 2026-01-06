package com.storeproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jakarta.persistence.*;
import com.storeproject.model.Product;


@Repository
public class ProductRepository implements JpaRepository<Product, Long> {
    
}
