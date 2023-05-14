package com.ing.hackathon.transactions.service;

import com.ing.hackathon.transactions.model.Account;
import com.ing.hackathon.transactions.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Account> generateReport(List<Transaction> transactions);
}
