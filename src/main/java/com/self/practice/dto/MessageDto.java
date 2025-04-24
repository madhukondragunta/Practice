package com.self.practice.dto;

import java.time.Instant;
import java.util.UUID;

public record MessageDto(String id, String content, Instant timestamp) {
    public MessageDto(String content) {
        this(UUID.randomUUID().toString(), content, Instant.now());
    }
}
