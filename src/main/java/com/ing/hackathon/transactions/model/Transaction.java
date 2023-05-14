package com.ing.hackathon.transactions.model;

import java.math.BigDecimal;

public record Transaction (String debitAccount, String creditAccount, BigDecimal amount) {
}