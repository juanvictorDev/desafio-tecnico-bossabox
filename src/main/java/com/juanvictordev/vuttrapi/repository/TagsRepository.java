package com.juanvictordev.vuttrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juanvictordev.vuttrapi.entity.Tags;

public interface TagsRepository extends JpaRepository<Tags, String>{
  
}
