package com.storeproject.service.user;
// import com.storeproject.dto.*;
import com.storeproject.model.*;

import java.util.*;

import org.springframework.stereotype.Service;

// import com.storeproject.Exceptions.*;
import com.storeproject.repository.*;;
@Service
public class UserService {


    protected UsersRepository userRepository;

    public UserService(
        UsersRepository userRepository)
        {
            this.userRepository = userRepository;
         }

        public Users addUser(Users newUser){
            return userRepository.save(newUser);
        }

        public void deleteUser( Long id){

            userRepository.deleteById(id);
        }

      public Users viewUserById(Long id){
        
           return  userRepository.getReferenceById(id);
         }
    
        // public User viewUserByEmail(String email)throws e{
        //         return userRepository.findByEmail(email;
        //  }

        public List<Users> viewAllUsers(){
            
            List<Users> users = userRepository.findAll();
            return users;
            }





}
