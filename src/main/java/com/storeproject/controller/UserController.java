package com.storeproject.controller;

import java.util.*;
// import com.storeproject.service.product.DeleteProductServiceInterfaceImplementation;
import com.storeproject.service.user.*;
// import com.storeproject.repository.*;
import com.storeproject.model.Users;

// import org.springframework.web.bind.annotation.RequestParam;
import  org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//  , DeleteProductServiceInterfaceImplementation deleteProductServiceInterfaceImplementation
    //   this.deleteProductServiceInterfaceImplementation = deleteProductServiceInterfaceImplementation;

@RestController
@RequestMapping("/users")
public class UserController {

    // private final DeleteProductServiceInterfaceImplementation deleteProductServiceInterfaceImplementation;

    private  UserService userService;
    
    // protected  UserRepository userRepository;

    public UserController
    (
         UserService userService
   ){
        this.userService=userService;
  
    }

    @PostMapping("/save-user")
    public ResponseEntity<?> CreateUser(@RequestBody Users user) {
        
        Users createdUser = userService.addUser(user);
        
        return  new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }


    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return ResponseEntity.ok("User sucessfully deleted");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        userService.viewUserById(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    // @GetMapping("/user/email")
    // public ResponseEntity<?> getUserByEmail(String email){
    //       User foundUser = userService.viewUserByEmail(email);
    //     return ResponseEntity.ok(foundUser);
    // }

    @GetMapping("/user/all-users")
    public ResponseEntity<List<Users>> getAllUsers(){    

        return ResponseEntity.ok(userService.viewAllUsers());
    }
    






}
