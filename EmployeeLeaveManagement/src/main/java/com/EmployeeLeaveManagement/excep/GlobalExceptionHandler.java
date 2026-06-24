package com.EmployeeLeaveManagement.excep;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object>
    handleResourceNotFound(ResourceNotFoundException ex) {

        Map<String,Object> error =
                new HashMap<>();

        error.put(
                "timestamp",
                LocalDateTime.now());

        error.put(
                "message",
                ex.getMessage());

        error.put(
                "status",
                HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(
            MethodArgumentNotValidException.class)
    public ResponseEntity<Object>
    handleValidationException(MethodArgumentNotValidException ex) {

        Map<String,String> errors =
                new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()));

        return new ResponseEntity<>(
                errors,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>
    handleGenericException(Exception ex) {

        Map<String,Object> error =
                new HashMap<>();

        error.put(
                "timestamp",
                LocalDateTime.now());

        error.put(
                "message",
                ex.getMessage());

        error.put(
                "status",
                HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(
                error,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
