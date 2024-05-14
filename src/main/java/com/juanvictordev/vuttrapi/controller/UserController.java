package com.juanvictordev.vuttrapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.juanvictordev.vuttrapi.dto.CreateUserDto;
import com.juanvictordev.vuttrapi.dto.LoginDto;
import com.juanvictordev.vuttrapi.entity.User;
import com.juanvictordev.vuttrapi.service.UserService;
import jakarta.validation.Valid;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
  
  @Autowired
  UserService userService;
  
  //CONTROLER PARA REGISTRAR USER
  @PostMapping("/register")
  public ResponseEntity<Void> postRegister(@Valid @RequestBody CreateUserDto requestBody) {
   User user = userService.registerUser(requestBody);
    if(user != null){
      return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }
  
  //CONTROLLER PARA LOGAR USER
  @PostMapping("/login")
  public ResponseEntity<Map<String, String>> postLogin(@Valid @RequestBody LoginDto requestBody) {
    
    return ResponseEntity.ok().body(Map.of("token", userService.loginUser(requestBody)));
  }
   
}