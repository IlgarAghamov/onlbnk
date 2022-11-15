package com.example.onlbnk.service;

import com.example.onlbnk.exception.CardException;
import com.example.onlbnk.exception.UserLoginException;
import com.example.onlbnk.model.Card;

import java.util.Optional;

public interface CardService {

    boolean createCard(Card card) throws CardException;

    boolean deleteCard(Long id) throws CardException;

    Optional<Card> getCardById(Long id) throws CardException;
}
