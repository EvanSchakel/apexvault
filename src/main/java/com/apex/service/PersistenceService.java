package com.apex.service;

import com.apex.model.Budget;
import com.apex.model.Transaction;
import java.util.List;

public interface PersistenceService {
    void saveTransactions(List<Transaction> transactions);
    List<Transaction> loadTransactions();
    void saveBudgets(List<Budget> budgets);
    List<Budget> loadBudgets();
}
