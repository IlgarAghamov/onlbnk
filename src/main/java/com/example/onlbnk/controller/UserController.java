package com.example.onlbnk.controller;


import com.example.onlbnk.controller.dto.CustomUserDTO;
import com.example.onlbnk.exception.UserLoginException;
import com.example.onlbnk.exception.UserLoginExceptionHandler;
import com.example.onlbnk.model.CustomUser;
import com.example.onlbnk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public CustomUser getUserById(@PathVariable("id") Long id) throws UserLoginException {

        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Boolean> createUser(@RequestBody CustomUser user) throws  UserLoginException {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id")Long id) throws UserLoginException {

        return userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public CustomUser updateUser(@PathVariable Long id, @RequestBody CustomUserDTO user){

        return userService.updateUser(id, user);

    }
}