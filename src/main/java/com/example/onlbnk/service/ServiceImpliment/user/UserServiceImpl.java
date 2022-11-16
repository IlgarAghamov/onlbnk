package com.example.onlbnk.service.ServiceImpliment.user;


import com.example.onlbnk.dto.card.CardResponseDTO;
import com.example.onlbnk.dto.user.CustomUserRequestDTO;
import com.example.onlbnk.dto.user.CustomUserResponseDTO;
import com.example.onlbnk.exception.user.UserLoginException;
import com.example.onlbnk.model.Card;
import com.example.onlbnk.model.CustomUser;
import com.example.onlbnk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public CustomUserResponseDTO getUserById(Long id) throws UserLoginException {
        Optional<CustomUser> user = userRepository.findById(id);
        if (user.isPresent()) {
            return getCustomUserResponseDTO(user);
        } else {
            throw new UserLoginException("This user doesn't exist");
        }
    }
    @Override
    public boolean createUser(CustomUserRequestDTO user) throws UserLoginException {
        if (userRepository.existsByUserLogin(user.getUserLogin())) {
            throw new UserLoginException("This login is not available");
        } else {
            CustomUser user1 = new CustomUser();
            user1.setUserLogin(user.getUserLogin());
            user1.setUserPassword(user.getUserPassword());
            userRepository.save(user1);
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
    public CustomUser updateUser(Long id, CustomUserRequestDTO user) {
       CustomUser customUser = userRepository.findById(id).get();
       customUser.setUserLogin(user.getUserLogin());
       customUser.setUserPassword(user.getUserPassword());

        return userRepository.save(customUser);
    }

    @Override
    public boolean transferMoney(CustomUser customUser, CustomUser customUser1) {
        return false;
    }

    private CustomUserResponseDTO getCustomUserResponseDTO(Optional<CustomUser> user) {
        CustomUserResponseDTO customUserResponseDTO = new CustomUserResponseDTO();
        List<CardResponseDTO> cardResponseDTOList = new ArrayList<>();
        customUserResponseDTO.setUsername(user.get().getUserLogin());
        customUserResponseDTO.setId(user.get().getUserId());
        List<Card> cards = user.get().getCards();

        for (Card card : cards) {
            CardResponseDTO cr = new CardResponseDTO();
            cr.setCardType(card.getCardType());
            cr.setCvc(card.getCardSecret());
            cr.setYears(card.getCardDate());
            cr.setBalance(card.getCardBalance());
            cardResponseDTOList.add(cr);
        }

        customUserResponseDTO.setUserCards(cardResponseDTOList);

        return customUserResponseDTO;
    }

}

