package com.storeproject.repository;
import com.storeproject.model.Users;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@DataJpaTest
public class UserRepositoryTest {

  
    private Users users1;
    private Users users2;

    @Autowired
     private  UsersRepository usersRepository;


    @BeforeEach
    public void Setup(){
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
     

    // @AfterEach
    // public static void tearDown(){
    //     usersRepository.deleteAll();
    // }

    @Test
    public void testSaveAndFindAllUsers(){
    usersRepository.saveAll(List.of(users1, users2));

     List<Users> savedUsers =usersRepository.findAll();
    assertEquals(2, savedUsers.size());
    }

    @Test
    public void findById_shouldReturnEntity_whenExistsEmpty_whenNotExists(){
        usersRepository.save(users1);
        Optional<Users> foundUsers = usersRepository.findById(users1.getId());
        assertAll(
            () ->assertTrue(foundUsers.isPresent()),
            () ->assertFalse(foundUsers.isEmpty())
        );

    }

    @Test
    public void findByEmail_shouldReturnEmail_whenExits(){
        usersRepository.save(users1);

        //custom query in rep
        Users userToBeFound = usersRepository.findByEmail(users1.getEmail());

        assertEquals(userToBeFound, users1 );
    }
    @Test
    public void deleteById_shouldRemoveEntity(){

        usersRepository.saveAll(List.of(users1, users2));
        
        usersRepository.deleteById(users1.getId());

        Optional<Users> deletedUser = usersRepository.findById(users1.getId());

        

        List<Users> savedUsers = usersRepository.findAll();
        assertAll(
            () ->assertTrue(deletedUser.isEmpty()),
            () ->assertEquals(1, savedUsers.size())
        );

    }
    


    
}
