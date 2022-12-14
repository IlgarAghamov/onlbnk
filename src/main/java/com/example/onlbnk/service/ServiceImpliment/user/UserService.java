package com.example.onlbnk.service.ServiceImpliment.user;

import com.example.onlbnk.dto.user.CustomUserRequestDTO;
import com.example.onlbnk.dto.user.CustomUserResponseDTO;
import com.example.onlbnk.exception.card.CardException;
import com.example.onlbnk.exception.user.UserLoginException;
import com.example.onlbnk.model.CustomUser;

import java.util.List;

public interface UserService {
    List<CustomUserResponseDTO> getUsers();

    CustomUserResponseDTO getUserById(Long id) throws UserLoginException;

    boolean createUser(CustomUserRequestDTO user) throws UserLoginException;

    boolean deleteUser(Long id) throws UserLoginException;

    CustomUser updateUser(Long id, CustomUserRequestDTO customUser);

    boolean transferMoney(Long senderId, Long recipientId, Long senderCardId, Long recipientCardId, float amount) throws CardException;

    boolean replenishTheBalance(Long cardId, float amount)
                throws CardException;
}

