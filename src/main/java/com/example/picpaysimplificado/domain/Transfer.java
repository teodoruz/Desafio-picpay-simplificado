package com.example.picpaysimplificado.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Transfer")
@Getter
@Setter
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id_transfer;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="payee")
    private User payee;

    @ManyToOne
    @JoinColumn(name="id_payer")
    private User payer;

    private LocalDateTime datetransfer;
}
