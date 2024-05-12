package com.juanvictordev.vuttrapi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.juanvictordev.vuttrapi.dto.ToolDto;
import com.juanvictordev.vuttrapi.entity.Tags;
import com.juanvictordev.vuttrapi.entity.Tools;
import com.juanvictordev.vuttrapi.repository.TagsRepository;
import com.juanvictordev.vuttrapi.repository.ToolsRepository;


@Service
public class ToolsService {
  
  @Autowired
  ToolsRepository toolsRepository;

  @Autowired
  TagsRepository tagsRepository;

  public Tools createTool(ToolDto toolDto){
  
    toolDto.tags().forEach(tag -> {
      Optional<Tags> tagFromDb = tagsRepository.findById(tag);

      if(tagFromDb.isEmpty()){
        tagsRepository.save(new Tags(tag));
      }
    });

    Set<Tags> tags = new HashSet<>();
    toolDto.tags().forEach(tag -> {
      tags.add(new Tags(tag));
    });

    Tools tools = new Tools(
      toolDto.title(),
      toolDto.link(), 
      toolDto.description(), 
      tags
    );

    return toolsRepository.save(tools);
  }

  public List<Tools> allTools(){
    return toolsRepository.findAll();
  }

  public List<Tools> filterTool(String tag){
    return toolsRepository.findByTagName(tag);
  }

}
