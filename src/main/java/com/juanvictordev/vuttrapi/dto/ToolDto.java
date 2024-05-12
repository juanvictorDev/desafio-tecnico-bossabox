package com.juanvictordev.vuttrapi.dto;

import java.util.Set;

public record ToolDto(String title, String link, String description, Set<String> tags) {
}