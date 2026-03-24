package com.storeproject.service.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.storeproject.repository.UsersRepository;
import com.storeproject.Exceptions.UserNotFoundException;
import com.storeproject.Exceptions.emailAlreadyExistsException;
import com.storeproject.model.*;
import com.storeproject.service.user.UserService;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTest {
    

    
    @Mock
    private UsersRepository userRepository;

    
    private UserService userService;


    public Users users1 = new Users();
    public Users users2 = new Users();
    @BeforeEach
    public void setup(){

        userService  = new UserService(userRepository);

         users1 = new Users();
        users1.setUsername("brian");
        users1.setPassword("password");
        users1.setFullname("brian ngetich");
        users1.setEmail("examplemail@gmail.com");
        users1.setAddress("1111 address ");
        users1.setCity("houston");
        users1.setState("arizona");
        users1.setZip("63088");

         users2 = new Users(
                    "michelle", 
                    "password",
                    "shell toti",
                    "shelltoti@gmail.com",
                    "1123 asress",
                    "stl",
                    "missouri",
                    "44333");


    }


    @Test
    public void  createUser_shouldPersistUser_whenValidData() throws Exception{

        ArgumentCaptor<Users> savedUser = ArgumentCaptor.forClass(Users.class);

        userService.addUser(users1);

        verify(userRepository, times(1)).save(savedUser.capture());

        assertEquals(savedUser.getValue(), users1);



        
    }

    @Test
    public void  createUser_shouldThrowExceptionIf_emailExists(){
    
        Users TempUser = new Users();
        TempUser.setEmail("example.xyz.com");
     
        
        when(userRepository.existsByEmail(TempUser.getEmail())).thenReturn(true);

        assertThrows(emailAlreadyExistsException.class, () ->  userService.addUser(TempUser));
    
    }

    @Test
   public void  getUserById_shouldReturnUser_whenUserExists() throws Exception{

    Long Id = 1L;

    // ArgumentCaptor<Users> retrievedUser = ArgumentCaptor.forClass(Users.class);
    when(userRepository.existsById(Id)).thenReturn(true);
     when (userRepository.getReferenceById(Id)).thenReturn(users1);

     Users tempUser = userService.viewUserById(Id);

     assertEquals(users1, tempUser);

   }

   @Test
    public void  getUserById_shouldThrowException_WhenUserDoestExist() throws Exception{
    
        Long Id = 1L;

        when(userRepository.existsById(Id)).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> userService.viewUserById(Id));
    }


   @Test
   public void getUserByEmail_shouldReturnUser_whenEmailExists_orThrowException() throws Exception{

         String email = "example@xyz.com";

         when(userRepository.existsByEmail(email)).thenReturn(true);
         when(userRepository.findByEmail(email)).thenReturn(users1);

         Users tempUser = userService.viewUserByEmail(email);

         assertEquals(users1, tempUser);

    
   }

   @Test
    public void getUserByEmail_shouldThrowException_whenEmailDoesntExist(){
        
         String email = "example@xyz.com";

         when(userRepository.existsByEmail(email)).thenReturn(false);

        assertThrows(UserNotFoundException.class, () -> userService.viewUserByEmail(email));

    }

   @Test
   public void getAllUsers_shouldReturnUsers_whenUsersExist_orReturnEmptyList() throws Exception{

        when(userRepository.findAll()).thenReturn(List.of(users1, users2));

        List<Users> tempUsers = userService.viewAllUsers();

        verify(userRepository, times(1)).findAll();

        assertEquals(tempUsers, List.of(users1, users2));



   }

    public void getAllUsers_shouldReturnEmptyList_whenUsersDontExist() throws Exception{
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(UserNotFoundException.class,() -> userService.viewAllUsers());
    }


   @Test
   public void updateUser_shouldModifyFields_whenUserExists_orThrowException(){

   }


   @Test
   public void deleteUser_should_ThrowExptionWhen_UserDoestExist(){
    
    when(userRepository.existsById(1L)).thenReturn(false);

    assertThrows(UserNotFoundException.class, () -> userService.deleteUser(1L));

   }


}
