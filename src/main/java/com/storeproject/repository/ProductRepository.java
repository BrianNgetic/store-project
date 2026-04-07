package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.storeproject.model.*;
import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import jakarta.persistence.LockModeType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Long> {


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("Select p FROM Product p WHERE p.id  = :id")
    Product findByIdForUpdates(@Param("id") Long id);

    List<Product> findByCategory(String category);
     
}
