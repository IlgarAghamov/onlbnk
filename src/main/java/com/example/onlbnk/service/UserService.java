package com.example.onlbnk.service;

import com.example.onlbnk.controller.dto.CustomUserDTO;
import com.example.onlbnk.exception.UserLoginException;
import com.example.onlbnk.model.CustomUser;

public interface UserService {
    CustomUser getUserById(Long id) throws UserLoginException;

    boolean createUser(CustomUser user) throws UserLoginException;

    boolean deleteUser(Long id) throws UserLoginException;

    CustomUser updateUser(Long id, CustomUserDTO customUser);
}

