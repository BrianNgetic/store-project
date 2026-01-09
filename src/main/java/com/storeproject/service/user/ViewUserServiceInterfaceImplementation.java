package com.storeproject.service.user;

import java.util.*;
import com.storeproject.model.User;
import com.storeproject.repository.UserRepository;

public class ViewUserServiceInterfaceImplementation {
    
        protected UserRepository userRepository;

        public ViewUserServiceInterfaceImplementation(UserRepository userRepository){
            this.userRepository = userRepository;
        }


         public User viewUserById(Long id){
        
           return  userRepository.getReferenceById(id);
         }

         public User viewUserByEmail(String email){
                return userRepository.findByEmail(email);
         }
        // public User viewUser(User currUser){
        //     return  userRepository.getClass(currUser);
        // }
        public List<User> viewAllUsers(){
            
            List<User> users = userRepository.findAll();
            return users;
            }

}
