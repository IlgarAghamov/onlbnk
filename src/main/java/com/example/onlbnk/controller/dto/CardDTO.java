package com.example.onlbnk.controller.dto;

import com.example.onlbnk.model.CustomUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private String cardNumber;
    private String cardType;
}
