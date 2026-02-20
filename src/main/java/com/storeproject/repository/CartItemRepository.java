package com.storeproject.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.storeproject.model.CartItem;
import com.storeproject.model.*;
import java.util.*;
import java.util.List;




@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long >{
  
    // void  deleteByProdId(Long id);
    List<CartItem> findByCart(Cart cart);
    Product findByProduct(Product product);
    CartItem findbyId(Long id);
    Optional<CartItem> findByCartAndProduct(Cart cart, Product product);

}
