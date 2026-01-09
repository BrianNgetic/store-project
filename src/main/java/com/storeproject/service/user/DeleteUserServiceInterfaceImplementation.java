package com.storeproject.service.user;


// import com.storeproject.model.User;
import com.storeproject.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public  class DeleteUserServiceInterfaceImplementation{

    UserRepository userRepository;

    public DeleteUserServiceInterfaceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void  deleteUser(Long id){
         userRepository.deleteById(id);
    }
}