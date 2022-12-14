package com.example.onlbnk.exception.user;

import com.example.onlbnk.exception.user.UserLoginException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserLoginExceptionHandler  {
    @ExceptionHandler(value = {UserLoginException.class})
    public ResponseEntity<String> handleException(UserLoginException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

