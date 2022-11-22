package com.example.onlbnk.dto.user;
import com.example.onlbnk.dto.card.CardResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserResponseDTO {
    private Long id;
    private String username;
    private List<CardResponseDTO> userCards;

}
