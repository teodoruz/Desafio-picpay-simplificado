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
    @JoinColumn(name="id_reciver")
    private User reciver;

    @ManyToOne
    @JoinColumn(name="id_sender")
    private User sender;

    private LocalDateTime datetransfer;
}
