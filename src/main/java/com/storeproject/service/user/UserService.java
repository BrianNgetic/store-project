package com.storeproject.service.user;
import com.storeproject.Exceptions.UserNotFoundException;
import com.storeproject.Exceptions.emailAlreadyExistsException;
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

        public Users addUser(Users newUser) throws Exception{
            if(userRepository.existsByEmail(newUser.getEmail())){
                throw new emailAlreadyExistsException();
            }
            return userRepository.save(newUser);

            
        }


        public void deleteUser( Long id) throws Exception{

        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }

            userRepository.deleteById(id);
        }

      public Users viewUserById(Long id) throws Exception{

        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        
           return  userRepository.getReferenceById(id);
         }
    
        // public User viewUserByEmail(String email)throws e{
        //         return userRepository.findByEmail(email;
        //  }

    public Users viewUserByEmail(String email) throws Exception{
        if(!userRepository.existsByEmail(email)){
            throw new UserNotFoundException();
        }

        return userRepository.findByEmail(email);
    }


        public List<Users> viewAllUsers() throws Exception{
            
            List<Users> users = userRepository.findAll();
            if(users.isEmpty()){
                throw new UserNotFoundException("No users found");
            }
            return users;
            }





}
