package com.example.onlbnk.service;

import com.example.onlbnk.model.User;

public interface UserService {
    User getUserById(Long id);

    User createUser(User user);

    boolean deleteUser(Long id);

    User updateUser(User user);
}

