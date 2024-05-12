package com.juanvictordev.vuttrapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.juanvictordev.vuttrapi.entity.Tags;

public interface TagsReposiroty extends JpaRepository<Tags, String>{
  
}
