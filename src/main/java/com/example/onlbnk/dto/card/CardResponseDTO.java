package com.example.onlbnk.dto.card;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDTO {

    private String cardType;
    @JsonFormat(pattern = "MM/yy")
    private Date cardDate;
    private int cardSecret;
    private float cardBalance;

}
