package com.example.onlbnk.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CardExceptionHandler {
    @ExceptionHandler(value = {CardException.class})
    public ResponseEntity<String> handleException(CardException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
