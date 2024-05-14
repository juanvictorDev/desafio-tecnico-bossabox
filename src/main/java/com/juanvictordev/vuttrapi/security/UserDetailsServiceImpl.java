package com.juanvictordev.vuttrapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.juanvictordev.vuttrapi.entity.User;
import com.juanvictordev.vuttrapi.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("usuario nao encontrado"));
    return new UserDetailsImpl(user);
  }
  
}
