package com.storeproject.dto;

import lombok.*;
import com.storeproject.model.Users;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class RegistrationDTO {

    PasswordEncoder passwordEncoder;
    
      String username;
      String password;
      String fullname;
      String email;
      String address;
      String city;
      String state;
      String zip;


   public Users CreateUser(PasswordEncoder passwordEncoder){
    Users user1 = new Users(username, passwordEncoder.encode(password), fullname, email, address, city, state, zip);
    return user1;
   }
}
