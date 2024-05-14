package com.juanvictordev.vuttrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanvictordev.vuttrapi.entity.RoleValue;
import com.juanvictordev.vuttrapi.entity.Roles;
import java.util.Optional;


public interface RoleRepository extends JpaRepository<Roles, Integer>{

  Optional<Roles> findByName(RoleValue name);

}
