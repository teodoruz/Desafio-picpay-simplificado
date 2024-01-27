package com.example.picpaysimplificado.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

public record TransactionDTO(
        BigDecimal value,
        Long idPeyee,
        Long idPayer
) {
}
