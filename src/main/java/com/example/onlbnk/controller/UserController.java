package com.example.onlbnk.controller;

import com.example.onlbnk.model.User;
import com.example.onlbnk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {

        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id")Long id){

        return userService.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user){

        return userService.updateUser(user);

    }
}