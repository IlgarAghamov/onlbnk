package com.example.onlbnk.controller;

import com.example.onlbnk.exception.CardException;
import com.example.onlbnk.model.Card;
import com.example.onlbnk.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("/card/{id}")
    public Optional<Card> getCardById(@PathVariable("id") Long id) throws CardException {

        return cardService.getCardById(id);
    }

    @PostMapping("/user/{id}/card")
    public ResponseEntity<Boolean> createCard(@RequestBody Card card) throws CardException {
        return ResponseEntity.ok(cardService.createCard(card));

    }
    @DeleteMapping("/card/{id}")
    public boolean deleteCard(@PathVariable("id")Long id) throws  CardException {

        return cardService.deleteCard(id);
    }
}

