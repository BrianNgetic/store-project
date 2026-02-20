package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.storeproject.model.*;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByUser(Users user);
    
    Order findByOrder(Order order);
}
