package com.juanvictordev.vuttrapi.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.juanvictordev.vuttrapi.dto.CreateUserDto;
import com.juanvictordev.vuttrapi.dto.LoginDto;
import com.juanvictordev.vuttrapi.entity.RoleValue;
import com.juanvictordev.vuttrapi.entity.Roles;
import com.juanvictordev.vuttrapi.entity.User;
import com.juanvictordev.vuttrapi.repository.RoleRepository;
import com.juanvictordev.vuttrapi.repository.UserRepository;
import com.juanvictordev.vuttrapi.security.JwtUtils;
import com.juanvictordev.vuttrapi.security.UserDetailsImpl;


@Service
public class UserService {
  
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  RoleRepository roleRepository;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  PasswordEncoder passwordEncoder;

  //METODO PARA REGISTRAR USUARIO
  public User registerUser(CreateUserDto createUserDto){

    //VERIFICA SE A ROLE PASSADA NO REQUESTBOY EXISTE NO BANCO
    Optional<Roles> role = roleRepository.findByName(RoleValue.valueOf(createUserDto.role()));
    
    //SE EXISTIR, APLICAR NO NOVO USER
    if(role.isPresent()){
      Set<Roles> setRole = new HashSet<>();
      setRole.add(role.get());
      User newUser = new User(
        createUserDto.email(),
        passwordEncoder.encode(createUserDto.password()),
        setRole
      );

      return userRepository.save(newUser);
    }

    return null;
  }

  //METODO PARA LOGAR USUARIO + RETORNAR TOKEN JWT
  public String loginUser(LoginDto loginDto){
    
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken 
    = new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password());
    
    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    
    return jwtUtils.gerarToken(userDetails);
  }

}
