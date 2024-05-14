package com.juanvictordev.vuttrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juanvictordev.vuttrapi.entity.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>{
  
  Optional<User> findByEmail(String email);

}