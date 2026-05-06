package com.apex.service;

import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import com.apex.model.Budget;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PerformanceBenchmark {

    static class DummyPersistence implements PersistenceService {
        List<Transaction> txs = new ArrayList<>();
        public void saveTransactions(List<Transaction> t) { txs = new ArrayList<>(t); }
        public List<Transaction> loadTransactions() { return new ArrayList<>(txs); }
        public void saveBudgets(List<Budget> b) { }
        public List<Budget> loadBudgets() { return new ArrayList<>(); }
    }

    public static void main(String[] args) {
        DummyPersistence p = new DummyPersistence();
        FinanceManager m = new FinanceManager(p);

        List<Transaction> txs = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == 0) {
                txs.add(new Transaction(LocalDate.now(), "Income", new BigDecimal("100.00"), "Income", TransactionType.INCOME));
            } else {
                txs.add(new Transaction(LocalDate.now(), "Expense", new BigDecimal("50.00"), "Expense", TransactionType.EXPENSE));
            }
        }
        p.saveTransactions(txs);
        FinanceManager m2 = new FinanceManager(p);

        // Warmup
        for (int i = 0; i < 10; i++) {
            m2.getTotalBalance();
        }

        // Benchmark
        long start = System.nanoTime();
        int iterations = 20;
        for (int i = 0; i < iterations; i++) {
            m2.getTotalBalance();
        }
        long end = System.nanoTime();

        System.out.println("Average time per call: " + ((end - start) / iterations / 1_000_000.0) + " ms");
    }
}
