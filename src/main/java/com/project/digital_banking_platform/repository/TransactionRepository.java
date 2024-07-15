package com.project.digital_banking_platform.repository;

import com.project.digital_banking_platform.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFromAccountIdOrToAccountId(Long fromAccountId, Long toAccountId);
}
