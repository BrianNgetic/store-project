package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository; //for jparepository
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository; //for repository
// import jakarta.persistence.*; //for the  columns  stuff
import com.storeproject.model.Users; //for the entity
// import java.util.List;
// import java.util.List;
import java.util.Optional;
import java.util.List;




@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    Optional<Users> findByUsername(String username);
    
    Optional findById(Long id);

    
    Users findByEmail(String email);

    boolean existsByEmail(String email);
}
