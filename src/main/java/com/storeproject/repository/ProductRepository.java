package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.storeproject.model.*;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
     
}
