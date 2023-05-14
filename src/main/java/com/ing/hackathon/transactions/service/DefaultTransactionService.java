package com.ing.hackathon.transactions.service;

import com.ing.hackathon.transactions.model.Account;
import com.ing.hackathon.transactions.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class DefaultTransactionService implements TransactionService{

    @Override
    public List<Account> generateReport(List<Transaction> transactions){
        Map<String, Account> accountMap = new HashMap<>();

        for (Transaction transaction : transactions) {
            String debitAccountNumber = transaction.debitAccount();
            String creditAccountNumber = transaction.creditAccount();
            BigDecimal amount = transaction.amount();

            Account debitAccount = accountMap.getOrDefault(debitAccountNumber, new Account(debitAccountNumber));
            Account creditAccount = accountMap.getOrDefault(creditAccountNumber, new Account(creditAccountNumber));

            debitAccount.transferTo(creditAccount, amount);
            accountMap.put(debitAccountNumber, debitAccount);
            accountMap.put(creditAccountNumber, creditAccount);
        }

        //parallelStream is slower than stream for <= 100k transactions
        return accountMap.values().stream()
                .sorted(Comparator.comparing(Account::getAccount))
                .collect(Collectors.toList());
    }
}
