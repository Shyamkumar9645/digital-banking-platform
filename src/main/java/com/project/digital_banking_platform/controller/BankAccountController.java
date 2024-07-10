package com.project.digital_banking_platform.controller;


import com.project.digital_banking_platform.entity.BankAccount;
import com.project.digital_banking_platform.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<BankAccount> getAccountById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return service.save(account);
    }

    @PutMapping("/{id}")
    public BankAccount updateAccount(@PathVariable Long id, @RequestBody BankAccount account) {
        account.setId(id);
        return service.save(account);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        service.deleteById(id);
    }
}


