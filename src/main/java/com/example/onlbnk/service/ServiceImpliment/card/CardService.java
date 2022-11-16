package com.example.onlbnk.service.ServiceImpliment.card;

import com.example.onlbnk.dto.card.CardRequestDTO;
import com.example.onlbnk.exception.card.CardException;
import com.example.onlbnk.model.Card;

import java.text.ParseException;
import java.util.Optional;

public interface CardService {

    boolean createCard(Long userId, CardRequestDTO cardRequestDTO) throws CardException, ParseException;

    boolean deleteCard(Long id) throws CardException;

    Optional<Card> getCardById(Long id) throws CardException;
}
