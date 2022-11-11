package com.example.onlbnk.service.ServiceImpliment;

import com.example.onlbnk.model.Card;
import com.example.onlbnk.repository.CardRepository;
import com.example.onlbnk.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public boolean deleteCard(Long id) {
        Optional<Card> card = cardRepository.findById(id);
        if(card.isPresent()){
            card.ifPresent(cardRepository::delete);
            return true;
        }else{
            return false;}
    }
}

