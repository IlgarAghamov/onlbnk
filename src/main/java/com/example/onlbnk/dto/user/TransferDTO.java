package com.example.onlbnk.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDTO {
    private long senderId;
    private long recipientId;
    private long senderCardId;
    private long recipientCardId;
    private float amount;
}
