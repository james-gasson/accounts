package com.example.accounts.rest;

import com.example.accounts.domain.Account;
import com.example.accounts.domain.Transaction;
import com.example.accounts.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAccounts();

        log.info("200 successful response from GET 'accounts'.");
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("{accountNumber}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountNumber) {
        List<Transaction> transactions = accountService.getTransactions(accountNumber);

        log.info("200 successful response from GET 'accounts/{accountNumber}/transactions'.");
        return ResponseEntity.ok(transactions);
    }
}
