package com.example.onlbnk.service.ServiceImpliment;

import com.example.onlbnk.exception.CardException;
import com.example.onlbnk.exception.UserLoginException;
import com.example.onlbnk.model.Card;
import com.example.onlbnk.model.CustomUser;
import com.example.onlbnk.repository.CardRepository;
import com.example.onlbnk.repository.UserRepository;
import com.example.onlbnk.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Override
    public boolean createCard(Long userId, int years, String cardType) throws  CardException {
       CustomUser user = userRepository.findById(userId).get();
       Calendar calendar = Calendar.getInstance();
       calendar.add(Calendar.YEAR, years);
       Card card = new Card();
       card.setCardId(/*generate card id)*/);
               card.setCardDate(calendar.getTime());
               card.setUser(user);
               card.setCardType(cardType);
               card.setCardBalance(0L);

        return true;
    }

    @Override
    public boolean deleteCard(Long id) throws CardException {
        Optional<Card> user = cardRepository.findById(id);
        if (user.isPresent()) {
            user.ifPresent(cardRepository::delete);
            return true;
        } else {
            throw new CardException("This user doesn't exist");

        }
    }

    @Override
    public Optional<Card> getCardById(Long id) throws CardException {
        Optional<Card> card = cardRepository.findById(id);
        if (card.isPresent()) {
            card.ifPresent(cardRepository::delete);
            return Optional.of(card.orElseGet(Card::new));
        } else {
            throw new CardException("This card doesn't exist");

        }

    }
}

