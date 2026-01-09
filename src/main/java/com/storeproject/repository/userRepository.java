package com.storeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository; //for jparepository
import org.springframework.stereotype.Repository; //for repository
// import jakarta.persistence.*; //for the  columns  stuff
import com.storeproject.model.User; //for the entity
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);;
}
