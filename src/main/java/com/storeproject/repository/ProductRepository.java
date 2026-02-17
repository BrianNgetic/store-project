package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.storeproject.model.*;

public interface ProductRepository extends JpaRepository<Product, Long> {
     
}
