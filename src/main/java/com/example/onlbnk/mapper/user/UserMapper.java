package com.example.onlbnk.mapper.user;

import com.example.onlbnk.dto.card.CardResponseDTO;
import com.example.onlbnk.dto.user.CustomUserResponseDTO;
import com.example.onlbnk.mapper.card.CardMapper;
import com.example.onlbnk.model.Card;
import com.example.onlbnk.model.CustomUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userLogin", source = "userLogin")
    @Mapping(target = "cards", source = "cards", qualifiedByName = "convertCards")
    CustomUserResponseDTO toDTO(CustomUser customUser);

    @Named("convertCards")
    static List<CardResponseDTO> convertCards(List<Card> cards) {
        List<CardResponseDTO> cardResponseDTOList = new ArrayList<>();
        for (Card card : cards) {
            cardResponseDTOList.add(CardMapper.INSTANCE.toDTO(card));
        }
        return cardResponseDTOList;
    }


}
