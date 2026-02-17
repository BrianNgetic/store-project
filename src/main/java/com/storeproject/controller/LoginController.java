package com.storeproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.storeproject.repository.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    public UsersRepository userRepository;

    // public LoginController(UserRepository userRepository){
    //     this.userRepository = userRepository;
    // }

    @GetMapping
    public String loginForm(){
        System.err.println("this also hit");
        return "login";
    }
}