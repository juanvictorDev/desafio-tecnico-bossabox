package com.juanvictordev.vuttrapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
  @NotBlank String email,
  @NotBlank String password,
  @NotBlank String role
) {}