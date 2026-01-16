package com.storeproject.controller;

import java.util.*;
// import com.storeproject.service.product.DeleteProductServiceInterfaceImplementation;
import com.storeproject.service.user.*;
// import com.storeproject.repository.*;
import com.storeproject.model.User;
import  org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

//  , DeleteProductServiceInterfaceImplementation deleteProductServiceInterfaceImplementation
    //   this.deleteProductServiceInterfaceImplementation = deleteProductServiceInterfaceImplementation;

@RestController
@RequestMapping("/users")
public class UserController {

    // private final DeleteProductServiceInterfaceImplementation deleteProductServiceInterfaceImplementation;

    private  AddUserServiceInterfaceImplementation addUserServiceInterfaceImplementation;
    private DeleteUserServiceInterfaceImplementation deleteUserServiceInterfaceImplementation;
    private   ViewUserServiceInterfaceImplementation  viewUserServiceInterfaceImplementation;
    
    // protected  UserRepository userRepository;

    public UserController
    (
        AddUserServiceInterfaceImplementation addUserServiceInterfaceImplementation,
     DeleteUserServiceInterfaceImplementation deleteUserServiceInterfaceimplementation,
       ViewUserServiceInterfaceImplementation  viewUserServiceInterfaceImplementation
   ){
        this.addUserServiceInterfaceImplementation = addUserServiceInterfaceImplementation;
        this.deleteUserServiceInterfaceImplementation = deleteUserServiceInterfaceImplementation;
        this.viewUserServiceInterfaceImplementation  = viewUserServiceInterfaceImplementation;
  
    }

    @PostMapping("/save-user")
    public ResponseEntity<?> CreateUser(@RequestBody User user) {
        
        User createdUser = addUserServiceInterfaceImplementation.addUser(user);
        
        return  new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }


    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long id){
        deleteUserServiceInterfaceImplementation.deleteUser(id);

        return ResponseEntity.ok("User sucessfully deleted");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        viewUserServiceInterfaceImplementation.viewUserById(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/email")
    public ResponseEntity<?> getUserByEmail(@RequestBody User user){
        viewUserServiceInterfaceImplementation.viewUserByEmail(user.Email);

         return new  ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/all-users")
    public ResponseEntity<List<User>> getAllUsers(){    

        return ResponseEntity.ok(viewUserServiceInterfaceImplementation.viewAllUsers());
    }
    






}
