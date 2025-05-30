package com.example.WikiUrfu.support;

import com.example.WikiUrfu.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptions {

    // Обработка 404 ошибок
    @ExceptionHandler({
            DepartmentNotFoundException.class,
            TeacherNotFoundException.class,
            InstituteNotFoundException.class
    })
    public ResponseEntity<ErrorResponse> handleNotFoundException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    // Обработка 409 конфликтов
    @ExceptionHandler({
            TeacherAlredyExistsException.class,
            InstituteAlreadyExistsException.class
    })
    public ResponseEntity<ErrorResponse> handleConflictException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value()));
    }

    // Обработка ошибок валидации
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> fe.getField() + ": " + fe.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse("Ошибка валидации", HttpStatus.BAD_REQUEST.value(), errors));
    }

    // Общая обработка 500 ошибок
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("Внутренняя ошибка сервера", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    // Внутренний класс для стандартизации ответов
    public static class ErrorResponse {
        private final String message;
        private final int status;
        private List<String> details;

        public ErrorResponse(String message, int status) {
            this.message = message;
            this.status = status;
        }

        public ErrorResponse(String message, int status, List<String> details) {
            this.message = message;
            this.status = status;
            this.details = details;
        }

        // Геттеры
        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }

        public List<String> getDetails() {
            return details;
        }
    }
}