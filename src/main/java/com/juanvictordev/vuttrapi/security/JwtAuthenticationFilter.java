package com.juanvictordev.vuttrapi.security;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.juanvictordev.vuttrapi.entity.User;
import com.juanvictordev.vuttrapi.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  UserRepository userRepository;

  //METODO PARA VALIDAR E AUTENTICAR O USER
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    
    String token = headerToken(request);
    if(token != null){
      String subject = jwtUtils.validarTokenComRetornoDoSubject(token);
      User user = userRepository.findByEmail(subject).get();
      UserDetailsImpl userDetails = new UserDetailsImpl(user);
      Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }
  
  //METODO UTILITARIO PARA PEGAR O TOKEN DO HEAD DA REQUEST
  String headerToken(HttpServletRequest request){
    String authorizationHeader = request.getHeader("Authorization");
    
    if (authorizationHeader != null) {
      return authorizationHeader.replace("Bearer ", "");
    }
    return null;
  }

}
