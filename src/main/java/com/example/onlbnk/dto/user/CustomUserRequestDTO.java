package com.example.onlbnk.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserRequestDTO {
    private String userLogin;
    private String userPassword;
}
