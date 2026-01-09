package com.storeproject.service.user;

import java.util.*;
import com.storeproject.model.User;



public interface ViewUserServiceInterface {
    public User viewUserById(User currentUser);
    public User viewUserByEmail(String email);

    public List<User> viewAllUsers(); //admin privilege
}
