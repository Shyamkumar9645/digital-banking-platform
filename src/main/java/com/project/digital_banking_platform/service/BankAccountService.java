package com.project.digital_banking_platform.service;


import com.project.digital_banking_platform.entity.Account;
import com.project.digital_banking_platform.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> findAll() {
        return repository.findAll();
    }

    public Optional<Account> findById(Long id) {
        return repository.findById(id);
    }

    public Account save(Account account) {
        return repository.save(account);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


