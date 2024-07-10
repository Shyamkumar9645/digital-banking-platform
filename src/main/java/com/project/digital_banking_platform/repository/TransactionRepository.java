package com.project.digital_banking_platform.repository;

import com.project.digital_banking_platform.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
