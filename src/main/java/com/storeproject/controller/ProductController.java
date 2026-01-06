package com.storeproject.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/product") // to add products
public class ProductController {
    @Autowired
    private Addproductservice addproductservice;
}

@GetMapping("/product/{id}")
public class  