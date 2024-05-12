package com.juanvictordev.vuttrapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.juanvictordev.vuttrapi.dto.ToolDto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import com.juanvictordev.vuttrapi.entity.Tools;
import com.juanvictordev.vuttrapi.service.ToolsService;

@RestController
public class ToolsController {
  
  @Autowired
  ToolsService toolsService;

  @GetMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Tools>> getAllTools() {
    
    return ResponseEntity.ok().body(toolsService.allTools());
  }
  
  //getFilterTools

  @PostMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Tools> postTool(@RequestBody ToolDto requestBody) {
       
    return ResponseEntity.status(201).body(toolsService.createTool(requestBody));
  }
  
}