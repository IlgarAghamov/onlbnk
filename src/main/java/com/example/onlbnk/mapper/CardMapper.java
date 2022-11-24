package com.example.onlbnk.mapper;

import com.example.onlbnk.dto.card.CardResponseDTO;
import com.example.onlbnk.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);
    CardResponseDTO toDTO(Card card);
}
