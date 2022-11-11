package com.example.onlbnk.controller;

import com.example.onlbnk.model.Card;
import com.example.onlbnk.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PostMapping("/card")
    public Card createCard(@RequestBody Card card) {

        return cardService.createCard(card);
    }
    @DeleteMapping("/card/{id}")
    public boolean deleteCard(@PathVariable("id")Long id){

        return cardService.deleteCard(id);
    }
}

