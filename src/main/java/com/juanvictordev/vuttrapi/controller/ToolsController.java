package com.juanvictordev.vuttrapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.juanvictordev.vuttrapi.dto.ToolDto;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.juanvictordev.vuttrapi.entity.Tools;
import com.juanvictordev.vuttrapi.service.ToolsService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ToolsController {
  
  @Autowired
  ToolsService toolsService;
  
  @GetMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Tools>> getAllToolsOrFilterTools(@RequestParam(defaultValue = "all_tags") String tag){
    if(tag.equals("all_tags")){
      return ResponseEntity.ok().body(toolsService.allTools());
    }else{
      return ResponseEntity.ok().body(toolsService.filterTool(tag));
    }
  }
  
  @PostMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Tools> postTool(@RequestBody ToolDto requestBody) {
    return ResponseEntity.status(201).body(toolsService.createTool(requestBody));
  }

  @DeleteMapping("tools/{id}")
  public ResponseEntity<Map<String, String>> deleteTool(@PathVariable Integer id){
    return toolsService.deleteTool(id);
  }
}