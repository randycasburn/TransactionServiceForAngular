package com.fidelity.transactionservice.repositories;

import com.fidelity.transactionservice.models.Transaction;
import com.fidelity.transactionservice.models.TransactionCategory;
import com.fidelity.transactionservice.models.TransactionType;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Repository
public class TransactionsRepository {

    private final List<Transaction> transactions = Arrays.asList(
            new Transaction(TransactionType.DR, "Amazon", TransactionCategory.GOODS, 100.01, LocalDate.of(2018, 1, 20)),
            new Transaction(TransactionType.CR, "Salary", TransactionCategory.DEPOSIT, 0.01, LocalDate.of(2018, 1, 31)),
            new Transaction(TransactionType.DR, "Acme Travel", TransactionCategory.TRAVEL, 568.99, LocalDate.of(2018, 2, 2)),
            new Transaction(TransactionType.DR, "Sue, Grabbit & Run", TransactionCategory.SERVICES, 4242.42, LocalDate.of(2018, 2, 2)),
            new Transaction(TransactionType.CR, "Mystery Benefactor", TransactionCategory.DEPOSIT, 9999.99, LocalDate.of(2018, 2, 10)),
            new Transaction(TransactionType.DR, "Amazon", TransactionCategory.GOODS, 369.98, LocalDate.of(2018, 2, 20)),
            new Transaction(TransactionType.CR, "Salary", TransactionCategory.DEPOSIT, 0.01, LocalDate.of(2018, 2, 28)),
            new Transaction(TransactionType.DR, "Acme Travel", TransactionCategory.TRAVEL, 1042.67, LocalDate.of(2018, 3, 1)),
            new Transaction(TransactionType.CR, "Salary", TransactionCategory.DEPOSIT, 0.01, LocalDate.of(2018, 3, 31)),
            new Transaction(TransactionType.DR, "Amazon", TransactionCategory.GOODS, 369.98, LocalDate.of(2018, 4, 12)),
            new Transaction(TransactionType.CR, "Salary", TransactionCategory.DEPOSIT, 0.01, LocalDate.of(2018, 4, 30))
    );

    public List<Transaction> getTransactions(String filter) {
        return transactions.stream()
                .filter(trans -> finder(trans, filter))
                .collect(Collectors.toList());
    }

    private Boolean finder(Transaction transaction, String filter) {
        if(filter.length() == 0) return true;
        else {
            return transaction.getCategory()
                    .equals(TransactionCategory.valueOf(filter.toUpperCase()));
        }
    }
}
