package com.storeproject.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class homeController {

    @GetMapping("/home")
    public String homePage(){
        return "home";
        }
    
    
}
