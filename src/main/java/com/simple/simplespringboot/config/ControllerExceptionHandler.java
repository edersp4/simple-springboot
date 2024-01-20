package com.simple.simplespringboot.config;

import com.simple.simplespringboot.exceptions.RequiredException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(RequiredException.class)
    public ResponseEntity<String> handleIllegalArgumentException(RequiredException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
