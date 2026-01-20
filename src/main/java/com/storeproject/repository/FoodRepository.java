package com.storeproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storeproject.model.Food;
// import jakarta.persistence.*;
// import com.storeproject.model.Product;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
            List<Food> findByCategory(String category);
}
