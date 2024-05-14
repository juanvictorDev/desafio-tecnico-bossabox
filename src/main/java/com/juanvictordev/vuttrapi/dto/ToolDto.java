package com.juanvictordev.vuttrapi.dto;

import java.util.Set;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record ToolDto(
  @NotBlank String title,
  @NotBlank String link,
  @NotBlank String description, 
  @NotEmpty Set<String> tags
) {}