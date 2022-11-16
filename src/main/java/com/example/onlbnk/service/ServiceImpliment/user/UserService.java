package com.example.onlbnk.service.ServiceImpliment.user;

import com.example.onlbnk.dto.user.CustomUserRequestDTO;
import com.example.onlbnk.dto.user.CustomUserResponseDTO;
import com.example.onlbnk.exception.user.UserLoginException;
import com.example.onlbnk.model.CustomUser;

public interface UserService {
    CustomUserResponseDTO getUserById(Long id) throws UserLoginException;

    boolean createUser(CustomUserRequestDTO user) throws UserLoginException;

    boolean deleteUser(Long id) throws UserLoginException;

    CustomUser updateUser(Long id, CustomUserRequestDTO customUser);

    boolean transferMoney(CustomUser customUser,CustomUser customUser1);
}

