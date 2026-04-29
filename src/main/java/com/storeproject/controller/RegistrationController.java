package com.storeproject.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import com.storeproject.repository.*;

import jakarta.validation.*;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

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
    public String registerForm(Model model){
       model.addAttribute("user", new RegistrationDTO());
       return "register";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("user") @Valid RegistrationDTO registrationDTO,   BindingResult result){
    //    User user = registrationDTO.CreateUser(passwordEncoder);
        if(result.hasErrors()){
                return "register";
        }
       Users CreatedUser = registrationDTO.CreateUser(passwordEncoder);
    
       userRepository.save(CreatedUser);
       CreatedUser.printUser();
        return "redirect:/login";
    }


}