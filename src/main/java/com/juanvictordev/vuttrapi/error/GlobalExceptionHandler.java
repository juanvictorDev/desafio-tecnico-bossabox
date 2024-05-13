package com.juanvictordev.vuttrapi.error;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.juanvictordev.vuttrapi.dto.ErrorBeanValidationDto;


@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
    
    //CRIANDO UMA NOVA RESPOSTA PERSONALIZADA PARA ERRO NO BEAN VALIDATION 

    List<ErrorBeanValidationDto> fields = new ArrayList<>();

    ex.getBindingResult().getFieldErrors().forEach(error -> {
      String field = error.getField();
      String message = error.getDefaultMessage();
      
      fields.add(new ErrorBeanValidationDto(field, message));
    });

    return ResponseEntity.badRequest().body(Map.of("errors", fields));
  }
}