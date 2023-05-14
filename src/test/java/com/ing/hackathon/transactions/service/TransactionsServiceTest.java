package com.ing.hackathon.transactions.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.hackathon.transactions.model.Transaction;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class TransactionsServiceTest {

    TransactionService transactionService = new DefaultTransactionService();

    @Test
    public void testOrderGenerationProcessingTime() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/transactions.json");
        List<Transaction> transactions = objectMapper.readValue(inputStream, new TypeReference<List<Transaction>>() {});

        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            transactionService.generateReport(transactions);
        }
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        System.out.println("Processing time: " + elapsedTime + " nanoseconds");
    }
}
