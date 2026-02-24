package com.storeproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository ;
import com.storeproject.model.*;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
    
}
