package com.ing.hackathon.transactions.controller;

import com.ing.hackathon.transactions.model.Account;
import com.ing.hackathon.transactions.model.Transaction;
import com.ing.hackathon.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    @PostMapping("/report")
    public ResponseEntity<List<Account>> returnReport(@RequestBody List<Transaction> transactions) {
        List<Account> accounts = transactionService.generateReport(transactions);
        return ResponseEntity.ok(accounts);
    }
}