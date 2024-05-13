package com.juanvictordev.vuttrapi.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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

  public Map<String, Object> allTools(Pageable pageable){
    Page<Tools> tools = toolsRepository.findAll(pageable);
    return pageResponse(tools);
  }

  public Map<String, Object> filterTool(String tag, Pageable pageable){
    Page<Tools> filterTools = toolsRepository.findByTagName(tag, pageable);
    return pageResponse(filterTools);
  }

  public ResponseEntity<Map<String, String>> deleteTool(Integer id){

    Optional<Tools> tool = toolsRepository.findById(id);
    
    if(tool.isPresent()){
      toolsRepository.deleteById(id);
      return ResponseEntity.ok(Map.of("msg", "tool com o ID: " + String.valueOf(id) + " excluido"));
    }else{
      return ResponseEntity.badRequest().body(Map.of("msg", "ID nao existe"));
    }
  }

  private Map<String, Object> pageResponse(Page<Tools> page){
    Map<String, Object> response = new HashMap<>();
    response.put("tools", page.getContent());
    response.put("current-page", page.getNumber());
    response.put("total-pages", page.getTotalPages());
    response.put("total-items", page.getTotalElements());

    return response;
  }
}
