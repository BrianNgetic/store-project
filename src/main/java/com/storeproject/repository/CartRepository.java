package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.storeproject.model.*;
import java.util.*;
import java.util.List;



@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
        Cart findByUser(Users user);
}
