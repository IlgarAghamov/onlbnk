package com.example.onlbnk.service.ServiceImpliment;


import com.example.onlbnk.controller.dto.CustomUserDTO;
import com.example.onlbnk.exception.UserLoginException;
import com.example.onlbnk.model.CustomUser;
import com.example.onlbnk.repository.UserRepository;
import com.example.onlbnk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public CustomUser getUserById(Long id) throws UserLoginException {
        Optional<CustomUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.ifPresent(userRepository::delete);
            return user.orElseGet(CustomUser::new);
        } else {
            throw new UserLoginException("This user doesn't exist");

        }


    }

    @Override
    public boolean createUser(CustomUser user) throws UserLoginException {
        if (userRepository.existsByUserLogin(user.getUserLogin())) {
            throw new UserLoginException("This login is not available");
        } else {
            userRepository.save(user);
        }
        return true;

    }

    @Override
    public boolean deleteUser(Long id) throws UserLoginException {
        Optional<CustomUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.ifPresent(userRepository::delete);
            return true;
        } else {
            throw new UserLoginException("This user doesn't exist");

        }

    }


    @Override
    public CustomUser updateUser(Long id, CustomUserDTO user) {
       CustomUser customUser = userRepository.findById(id).get();
       customUser.setUserLogin(user.getUserLogin());
       customUser.setUserPassword(user.getUserPassword());

        return userRepository.save(customUser);
    }


}

