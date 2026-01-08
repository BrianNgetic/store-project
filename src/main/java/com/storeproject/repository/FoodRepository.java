package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// import jakarta.persistence.*;
import com.storeproject.model.Product;

@Repository
public interface FoodRepository extends JpaRepository<Product, Long> {
    
}
