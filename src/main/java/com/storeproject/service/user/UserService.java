package com.storeproject.service.user;
// import com.storeproject.dto.*;
import com.storeproject.model.*;

import java.util.*;

import org.springframework.stereotype.Service;

// import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;;
@Service
public class UserService {


    protected UserRepository userRepository;

    public UserService(
        UserRepository userRepository)
        {
            this.userRepository = userRepository;
         }

        public User addUser(User newUser){
            return userRepository.save(newUser);
        }

        public void deleteUser( Long id){

            userRepository.deleteById(id);
        }

      public User viewUserById(Long id){
        
           return  userRepository.getReferenceById(id);
         }
    
        public User viewUserByEmail(String email){
                return userRepository.findByEmail(email);
         }

        public List<User> viewAllUsers(){
            
            List<User> users = userRepository.findAll();
            return users;
            }





}
