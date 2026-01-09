package com.storeproject.service.user;

import com.storeproject.repository.UserRepository;
import com.storeproject.model.User;
public class AddUserServiceInterfaceImplementation {


     final UserRepository userRepository;

     public AddUserServiceInterfaceImplementation(UserRepository userRepository){
        this.userRepository  = userRepository;
     }


    public User addUser(User newUser ){
            return userRepository.save(newUser);
        }
    }
