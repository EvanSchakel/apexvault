package com.apex.service;

import com.apex.model.Budget;
import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinanceManager {
    private final List<Transaction> transactions;
    private final List<Budget> budgets;
    private final PersistenceService persistence;

    public FinanceManager(PersistenceService persistence) {
        this.persistence = persistence;
        this.transactions = persistence.loadTransactions();
        this.budgets = persistence.loadBudgets();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        persistence.saveTransactions(transactions);
    }

    public void setBudget(String category, BigDecimal limit) {
        budgets.removeIf(b -> b.getCategory().equalsIgnoreCase(category));
        budgets.add(new Budget(category, limit));
        persistence.saveBudgets(budgets);
    }

    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }

    public List<Budget> getAllBudgets() {
        return new ArrayList<>(budgets);
    }

    public BigDecimal getTotalBalance() {
        // Optimization: Single-pass imperative loop avoids stream overhead and duplicate traversals.
        BigDecimal income = BigDecimal.ZERO;
        BigDecimal expenses = BigDecimal.ZERO;

        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.INCOME) {
                income = income.add(t.getAmount());
            } else if (t.getType() == TransactionType.EXPENSE) {
                expenses = expenses.add(t.getAmount());
            }
        }

        return income.subtract(expenses);
    }

    public Map<String, BigDecimal> getSpendingByCategory() {
        // Optimization: Single-pass imperative loop avoids stream overhead for aggregation.
        Map<String, BigDecimal> spending = new java.util.HashMap<>();
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.EXPENSE) {
                spending.merge(t.getCategory(), t.getAmount(), BigDecimal::add);
            }
        }
        return spending;
    }
}
