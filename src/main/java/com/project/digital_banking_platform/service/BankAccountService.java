package com.project.digital_banking_platform.service;


import com.project.digital_banking_platform.entity.BankAccount;
import com.project.digital_banking_platform.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    public List<BankAccount> findAll() {
        return repository.findAll();
    }

    public Optional<BankAccount> findById(Long id) {
        return repository.findById(id);
    }

    public BankAccount save(BankAccount account) {
        return repository.save(account);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


