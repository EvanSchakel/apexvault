package com.apex.service;

import com.apex.model.Budget;
import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FinanceManagerTest {

    static class InMemoryPersistence implements PersistenceService {
        List<Transaction> txs = new ArrayList<>();
        List<Budget> bgs = new ArrayList<>();

        @Override
        public void saveTransactions(List<Transaction> transactions) {
            this.txs = new ArrayList<>(transactions);
        }

        @Override
        public List<Transaction> loadTransactions() {
            return new ArrayList<>(txs);
        }

        @Override
        public void saveBudgets(List<Budget> budgets) {
            this.bgs = new ArrayList<>(budgets);
        }

        @Override
        public List<Budget> loadBudgets() {
            return new ArrayList<>(bgs);
        }
    }

    @Test
    void totalBalanceAndSpendingByCategory() {
        InMemoryPersistence p = new InMemoryPersistence();
        FinanceManager m = new FinanceManager(p);

        m.addTransaction(new Transaction(LocalDate.now(), "Salary", new BigDecimal("1000.00"), "Income", TransactionType.INCOME));
        m.addTransaction(new Transaction(LocalDate.now(), "Coffee", new BigDecimal("3.50"), "Food", TransactionType.EXPENSE));

        BigDecimal balance = m.getTotalBalance();
        assertEquals(0, balance.compareTo(new BigDecimal("996.50")));

        Map<String, BigDecimal> spending = m.getSpendingByCategory();
        assertTrue(spending.containsKey("Food"));
        assertEquals(0, spending.get("Food").compareTo(new BigDecimal("3.50")));

        m.setBudget("Food", new BigDecimal("50.00"));
        List<Budget> budgets = m.getAllBudgets();
        assertFalse(budgets.isEmpty());
        assertEquals("Food", budgets.get(0).getCategory());
    }
}
