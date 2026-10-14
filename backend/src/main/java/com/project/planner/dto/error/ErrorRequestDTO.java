package com.project.planner.dto.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorRequestDTO (
        int status,
        LocalDateTime timestamp,
        String message,
        Map<String, String> errors
) {
}
