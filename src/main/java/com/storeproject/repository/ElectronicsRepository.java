package com.storeproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.storeproject.model.Electronics;
// import jakarta.persistence.*;
// import com.storeproject.model.Product;

@Repository
public interface ElectronicsRepository extends JpaRepository<Electronics, Long> {
        List<Electronics> findByCategory(String category);
}
    