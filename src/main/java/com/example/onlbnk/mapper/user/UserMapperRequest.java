package com.example.onlbnk.mapper.user;

import com.example.onlbnk.dto.user.CustomUserRequestDTO;
import com.example.onlbnk.model.CustomUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperRequest {
    UserMapperRequest INSTANCE = Mappers.getMapper(UserMapperRequest.class);
    CustomUserRequestDTO toDTO(CustomUser customUser);
}
