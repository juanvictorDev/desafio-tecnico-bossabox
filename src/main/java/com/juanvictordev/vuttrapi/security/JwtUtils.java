package com.juanvictordev.vuttrapi.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;


@Service
public class JwtUtils {
  
  private static final String SECRET_KEY = "javaMelhorQuePython";
  private static final String ISSUER = "vuttr-api";
  
  //METODO PARA GERAR O JWT
  public String gerarToken(UserDetailsImpl user){
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
      String jwtToken = JWT.create()
        .withIssuer(ISSUER)
        .withIssuedAt(creationTime())
        .withExpiresAt(expirationTime())
        .withSubject(user.getUsername())
        .sign(algorithm);

      return jwtToken;

    } catch (Exception ex) {
      throw new JWTCreationException("Erro ao gerar token.", ex);
    }
  }

  //METODO PARA VALIDAR O JWT + RETORNAR O SUBJECT
  public String validarTokenComRetornoDoSubject(String token){
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
      String subject = JWT.require(algorithm)
        .withIssuer(ISSUER)
        .build()
        .verify(token)
        .getSubject();
         
      return subject;

    } catch (Exception e) {
      throw new JWTVerificationException("Token invalido ou expirado");
    }
  }

  //METODOS UTILITARIOS
  private Instant creationTime(){
    return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
  }
  private Instant expirationTime(){
    return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
  }
}
