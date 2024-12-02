package com.example.demo.adapter.controller;

import com.example.demo.exceptions.ClienteDuplicadoException;
import com.example.demo.exceptions.ClienteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandlers {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClienteDuplicadoException.class)
    public Map<String, String> handle(ClienteDuplicadoException ex) {
        Map<String, String> errors = new HashMap<>();
            String errorMessage = ex.getMessage();
            errors.put("cause", errorMessage);
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClienteNotFoundException.class)
    public Map<String, String> handle(ClienteNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        String errorMessage = ex.getMessage();
        errors.put("cause", errorMessage);
        return errors;
    }

}
