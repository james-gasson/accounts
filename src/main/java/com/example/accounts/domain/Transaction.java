package com.example.accounts.domain;

import lombok.Value;

@Value
public class Transaction {
    private String accountNumber;
    private String accountName;
    private String valueDate;
    private String currency;
    private String debitAmount;
    private String creditAmount;
    private String debitOrCredit;
    private String transactionNarrative;
}
