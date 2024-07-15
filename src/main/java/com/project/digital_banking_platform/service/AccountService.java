package com.project.digital_banking_platform.service;

import com.project.digital_banking_platform.entity.Account;
import com.project.digital_banking_platform.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Create a new account
    public Account createAccount(Account account) {
        account.setBalance(BigDecimal.ZERO); // Initialize balance to zero
        return accountRepository.save(account);
    }

    // Get all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Get account by ID
    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    // Update an existing account
    public Account updateAccount(Long accountId, Account accountDetails) {
        Account existingAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        existingAccount.setAccountType(accountDetails.getAccountType());
        existingAccount.setAccountNumber(accountDetails.getAccountNumber());
        existingAccount.setCurrency(accountDetails.getCurrency());

        return accountRepository.save(existingAccount);
    }

    // Delete an account
    public boolean deleteAccount(Long accountId) {
        Account existingAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        accountRepository.delete(existingAccount);
        return false;
    }
}
