package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository; //for jparepository
import org.springframework.stereotype.Repository; //for repository
// import jakarta.persistence.*; //for the  columns  stuff
import com.storeproject.model.Users; //for the entity
// import java.util.List;
// import java.util.List;
import java.util.Optional;



@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUsername(String username);

    Optional<Users>findByEmail(String email);
}
