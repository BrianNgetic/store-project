package com.storeproject.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import com.storeproject.repository.*;
import com.storeproject.dto.RegistrationDTO;
import com.storeproject.model.*;

@Controller
@RequestMapping("/register")
public class RegistrationController{
    private   UsersRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
       UsersRepository userRepository,
       PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(){
        return "register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute RegistrationDTO registrationDTO){
    //    User user = registrationDTO.CreateUser(passwordEncoder);
       System.out.println("this hit");
       System.out.println(registrationDTO);
       userRepository.save(registrationDTO.CreateUser(passwordEncoder));
        return "redirect:/login";
    }
  

}