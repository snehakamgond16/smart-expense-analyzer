package com.spring.smartexpense.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Resource Not Found
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Void>> handleRuntimeException(RuntimeException ex) {

        ApiResponse<Void> response = new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Bad Request (validation errors etc.)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(IllegalArgumentException ex) {

        ApiResponse<Void> response = new ApiResponse<>(
                false,
                ex.getMessage(),
                null
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Catch All Other Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {

        ApiResponse<Void> response = new ApiResponse<>(
                false,
                "Something went wrong",
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}