package com.example.onlbnk.controller;


import com.example.onlbnk.dto.user.CustomUserRequestDTO;
import com.example.onlbnk.dto.user.CustomUserResponseDTO;
import com.example.onlbnk.exception.user.UserLoginException;
import com.example.onlbnk.model.CustomUser;
import com.example.onlbnk.service.ServiceImpliment.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public CustomUserResponseDTO getUserById(@PathVariable("id") Long id)
            throws UserLoginException {

        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public ResponseEntity<Boolean> createUser(@RequestBody CustomUserRequestDTO user) throws  UserLoginException {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id")Long id) throws UserLoginException {

        return userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public CustomUser updateUser(@PathVariable Long id, @RequestBody CustomUserRequestDTO user){

        return userService.updateUser(id, user);

    }
}