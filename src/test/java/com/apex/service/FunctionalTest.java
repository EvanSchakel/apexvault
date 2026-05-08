package com.apex.service;

import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import com.apex.model.Budget;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FunctionalTest {

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

    public static void main(String[] args) {
        InMemoryPersistence p = new InMemoryPersistence();
        FinanceManager m = new FinanceManager(p);

        m.addTransaction(new Transaction(LocalDate.now(), "Salary", new BigDecimal("1000.00"), "Income", TransactionType.INCOME));
        m.addTransaction(new Transaction(LocalDate.now(), "Coffee", new BigDecimal("3.50"), "Food", TransactionType.EXPENSE));

        BigDecimal balance = m.getTotalBalance();
        if (balance.compareTo(new BigDecimal("996.50")) != 0) {
            throw new RuntimeException("Balance is wrong: " + balance);
        }

        Map<String, BigDecimal> spending = m.getSpendingByCategory();
        if (!spending.containsKey("Food")) {
            throw new RuntimeException("Missing Food spending");
        }
        if (spending.get("Food").compareTo(new BigDecimal("3.50")) != 0) {
            throw new RuntimeException("Food spending is wrong: " + spending.get("Food"));
        }

        m.setBudget("Food", new BigDecimal("50.00"));
        List<Budget> budgets = m.getAllBudgets();
        if (budgets.isEmpty() || !budgets.get(0).getCategory().equals("Food")) {
            throw new RuntimeException("Budgets are wrong");
        }

        System.out.println("All tests passed!");
    }
}
