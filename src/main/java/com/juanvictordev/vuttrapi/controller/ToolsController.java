package com.juanvictordev.vuttrapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.juanvictordev.vuttrapi.dto.ToolDto;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.juanvictordev.vuttrapi.entity.Tools;
import com.juanvictordev.vuttrapi.service.ToolsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ToolsController {
  
  @Autowired
  ToolsService toolsService;
  
  //ENDPOINT DUPLO QUE FAZ UM SELECT DIFERENTE DE ACORDO COM O VALOR DA TAG PASSADA NO PARAMETRO DA URL
  @GetMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<String, Object>> getAllToolsOrFilterTools(
      @RequestParam(defaultValue = "all_tags") String tag,
      @RequestParam(defaultValue = "0") Integer  pageNumber,
      @RequestParam(defaultValue = "5") Integer  size
    ){
    if(tag.equals("all_tags")){
      return ResponseEntity.ok().body(toolsService.allTools(PageRequest.of(pageNumber, size)));
    }
    else{
      return ResponseEntity.ok().body(toolsService.filterTool(tag, PageRequest.of(pageNumber, size)));
    }
  }

  //ENDPOINT PARA CRIAR TOOL
  @PostMapping(value = "/tools", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Tools> postTool(@Valid @RequestBody ToolDto requestBody) {
    return ResponseEntity.status(201).body(toolsService.createTool(requestBody));
  }
  
  //ENDPOINT PARA DELETAR TOOL
  @DeleteMapping("tools/{id}")
  public ResponseEntity<Map<String, String>> deleteTool(@PathVariable Integer id){
    return toolsService.deleteTool(id);
  }
}