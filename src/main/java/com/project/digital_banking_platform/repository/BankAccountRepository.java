package com.project.digital_banking_platform.repository;

import com.project.digital_banking_platform.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}

