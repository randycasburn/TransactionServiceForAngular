package com.fidelity.transactionservice.endpoints;

import com.fidelity.transactionservice.models.Transaction;
import com.fidelity.transactionservice.repositories.TransactionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionsRepository repo;

    public TransactionController(TransactionsRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/txns")
    public List<Transaction> getTransactions(@RequestParam(defaultValue = "") String filter) {
        try {
            return repo.getTransactions(filter);
            // Will throw if ENUM value does not exist
        } catch (IllegalArgumentException exc) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid filter: " + filter, exc);
        }
    }
}

