package com.example.accounts.client;

import com.example.accounts.domain.Account;
import com.example.accounts.domain.Transaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "UpstreamClient", url = "http://localhost:8304")
public interface UpstreamClient {
    @GetMapping(path = "/accounts")
    List<Account> getAccounts();

    @GetMapping(path = "/accounts/{accountNumber}/transactions")
    List<Transaction> getTransactions(@PathVariable String accountNumber);
}
