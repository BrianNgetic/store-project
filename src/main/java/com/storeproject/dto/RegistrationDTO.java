package com.storeproject.dto;

import lombok.*;
import com.storeproject.model.Users;

import jakarta.validation.constraints.*;

import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class RegistrationDTO {

    PasswordEncoder passwordEncoder;
    
      @NotBlank(message =  "Username cannot be empty")
      String username;

      @NotBlank
      @Size(min = 5 , max = 10)
      String password;

      @NotBlank
      String fullname;

      @Email
      String email;

      @NotBlank
      String address;

      @NotBlank
      String city;

      @NotBlank
      String state;

      @NotBlank
      String zip;


   public Users CreateUser(PasswordEncoder passwordEncoder){
    Users user1 = new Users(username, passwordEncoder.encode(password), fullname, email, address, city, state, zip);
    return user1;
   }
}
