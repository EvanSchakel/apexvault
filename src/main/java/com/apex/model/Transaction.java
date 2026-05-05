package com.apex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final LocalDate date;
    private final String description;
    private final BigDecimal amount;
    private final String category;
    private final TransactionType type;

    public Transaction(LocalDate date, String description, BigDecimal amount, String category, TransactionType type) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    // Constructor for persistence
    public Transaction(String id, LocalDate date, String description, BigDecimal amount, String category, TransactionType type) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.type = type;
    }

    public String getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
    public BigDecimal getAmount() { return amount; }
    public String getCategory() { return category; }
    public TransactionType getType() { return type; }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s %s (%s)", id, date, type == TransactionType.INCOME ? "+" : "-", amount, category);
    }
}
