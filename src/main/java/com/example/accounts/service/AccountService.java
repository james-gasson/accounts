package com.example.accounts.service;

import com.example.accounts.client.UpstreamClient;
import com.example.accounts.domain.Account;
import com.example.accounts.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final UpstreamClient upstreamClient;

    private final String TRANSACTIONS_URL = "http://localhost:8201/accounts/%s/transactions";
    private final String TRANSACTION_REL = "transactions";

    @Autowired
    public AccountService(UpstreamClient upstreamClient) {
        this.upstreamClient = upstreamClient;
    }

    public List<Account> getAccounts() {
        List<Account> accounts = upstreamClient.getAccounts();

        return accounts.parallelStream().map(a -> {
            String url = String.format(TRANSACTIONS_URL, a.getNumber());
            return a.add(Link.of(url, TRANSACTION_REL));
        }).collect(Collectors.toList());
    }

    public List<Transaction> getTransactions(String accountNumber) {
        return upstreamClient.getTransactions(accountNumber);
    }
}
