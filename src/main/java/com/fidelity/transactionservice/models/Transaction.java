package com.fidelity.transactionservice.models;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Transaction {
    private TransactionType transactionType;
    private String details;
    private TransactionCategory category;
    private double value;
    private LocalDate transactionDate;

    public Transaction(TransactionType transactionType, String details, TransactionCategory category, double value,
                       LocalDate transactionDate) {
        this.transactionType = transactionType;
        this.details = details;
        this.category = category;
        this.value = value;
        this.transactionDate = transactionDate;
    }

    public Transaction() {
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public TransactionCategory getCategory() {
        return category;
    }

    public void setCategory(TransactionCategory category) {
        this.category = category;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction [transactionType=" + transactionType + ", details=" + details + ", category=" + category
                + ", value=" + value + ", transactionDate=" + transactionDate + "]";
    }

}
