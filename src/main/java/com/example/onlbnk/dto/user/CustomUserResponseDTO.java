package com.example.onlbnk.dto.user;
import com.example.onlbnk.dto.card.CardResponseDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomUserResponseDTO {
    private Long userId;
    private String userLogin;
    private List<CardResponseDTO> cards;


}
