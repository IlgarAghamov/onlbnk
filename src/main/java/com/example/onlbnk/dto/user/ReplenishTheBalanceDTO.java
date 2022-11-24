package com.example.onlbnk.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplenishTheBalanceDTO {
    Long cardId;
    float amount;
}
