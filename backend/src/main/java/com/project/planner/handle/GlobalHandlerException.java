package com.project.planner.handle;

import com.project.planner.dto.error.ErrorRequestDTO;
import com.project.planner.dto.error.ErrorResponseDTO;
import com.project.planner.exception.BadRequestException;
import com.project.planner.exception.BusinessRulesException;
import com.project.planner.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandlerException {

    // ======================== Builders ========================
    public ResponseEntity<ErrorResponseDTO> buildResponseError(
            HttpStatus status,
            String message
    ) {
        ErrorResponseDTO error = new ErrorResponseDTO(
                status.value(),
                LocalDateTime.now(),
                message
        );

        return ResponseEntity
                .status(status)
                .body(error);
    }

    public ResponseEntity<ErrorRequestDTO> buildRequestError(
            HttpStatus status,
            String message,
            Map<String, String> errors
    ) {
        ErrorRequestDTO error = new ErrorRequestDTO(
                status.value(),
                LocalDateTime.now(),
                message,
                errors
        );

        return ResponseEntity
                .status(status)
                .body(error);
    }

    // ======================== Handles ========================

    @ExceptionHandler(BusinessRulesException.class)
    public ResponseEntity<ErrorResponseDTO> handleBusinessRules(BusinessRulesException ex) {
        return  buildResponseError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRequestDTO> handleBadRequest (MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return buildRequestError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                errors
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(ResourceNotFoundException ex) {
        return buildResponseError(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGeneric() {
        return buildResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server Error"
        );
    }

}
