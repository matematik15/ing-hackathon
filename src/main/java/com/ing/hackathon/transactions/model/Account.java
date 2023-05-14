package com.ing.hackathon.transactions.model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Account {
    private final String account;
    private int debitCount = 0;
    private int creditCount = 0;
    private BigDecimal balance = new BigDecimal(0);

    public void transferTo(Account other, BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        this.debitCount += 1;

        other.balance = other.balance.add(amount);
        other.creditCount += 1;
    }
}