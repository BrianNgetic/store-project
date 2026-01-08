package com.storeproject.service;
import java.util.List;

import com.storeproject.model.Product;

public interface ViewProductServiceInterface {
    public Product viewById (Long id);
    public List<Product> viewByCategory(String category);
    public List<Product> viewAllProducts();
    
}
