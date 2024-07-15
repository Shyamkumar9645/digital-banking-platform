package com.project.digital_banking_platform.repository;

import com.project.digital_banking_platform.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

