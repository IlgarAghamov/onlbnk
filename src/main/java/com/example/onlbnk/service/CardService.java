package com.example.onlbnk.service;

import com.example.onlbnk.model.Card;

public interface CardService {
    Card createCard(Card card);

    boolean deleteCard(Long id);
}
