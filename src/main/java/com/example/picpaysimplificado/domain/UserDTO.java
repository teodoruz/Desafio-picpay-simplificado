package com.example.picpaysimplificado.domain;

import java.math.BigDecimal;

public record UserDTO(
        BigDecimal balance,
        String email,
        UserType userType,
        String document,
        String name,
        String password) {
}
