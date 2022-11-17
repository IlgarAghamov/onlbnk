package com.example.onlbnk.service.ServiceImpliment.card;

import com.example.onlbnk.dto.card.CardRequestDTO;
import com.example.onlbnk.exception.card.CardException;
import com.example.onlbnk.model.Card;
import com.example.onlbnk.model.CustomUser;
import com.example.onlbnk.repository.CardRepository;
import com.example.onlbnk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final UserRepository userRepository;

    private final Random random = new Random();

    @Override
    public boolean createCard(Long userId, CardRequestDTO cardRequestDTO) throws CardException, ParseException {
        CustomUser user = userRepository.findById(userId).get();
        Card card = new Card();
        card.setCardDate(createCardDate(cardRequestDTO.getYears()));
        card.setCardNumber(createCardNumber());
        card.setUser(user);
        card.setCardType(cardRequestDTO.getCardType());
        card.setCardBalance(0L);
        card.setCardSecret(generateRandom4Digits(999,100));

        cardRepository.save(card);
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

    private Date createCardDate(int years) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, years);
        return calendar.getTime();
    }

    private String createCardNumber() {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result = result.concat(String.valueOf(generateRandom4Digits(9000,1000)));
        }
        return result;
    }

    private int generateRandom4Digits(int max ,int min) {return random.nextInt(max) + min;
    }

    }


