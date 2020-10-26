package com.example.accounts.domain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import org.springframework.hateoas.RepresentationModel;


@Value
@EqualsAndHashCode(callSuper = true)
public class Account extends RepresentationModel<Account> {
    @NonNull
    private String number;
    private String name;
    private String type;
    private String balanceDate;
    private String currency;
    private String openingAvailableBalance;
}
