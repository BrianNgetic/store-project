package com.storeproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.storeproject.repository.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    public UsersRepository userRepository;
    
    @GetMapping
    public String loginForm(){
      
        return "login";
    }
}