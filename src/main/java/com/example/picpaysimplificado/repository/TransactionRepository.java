package com.example.picpaysimplificado.repository;

import com.example.picpaysimplificado.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transfer, Long> {
}
