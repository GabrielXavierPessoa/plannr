package com.project.planner.dto.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDTO (
        int status,
        LocalDateTime timestamp,
        String message
) {
}
