package com.example.onlbnk.mapper.card;

import com.example.onlbnk.dto.card.CardRequestDTO;
import com.example.onlbnk.dto.card.CardResponseDTO;
import com.example.onlbnk.model.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


//kak dobavit card.years
@Mapper
public interface CardMapperRequest {
    CardMapperRequest INSTANCE = Mappers.getMapper(CardMapperRequest.class);
    CardRequestDTO toDTO(Card card);
}
