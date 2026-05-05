package com.apex.service;

import com.apex.model.Budget;
import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FilePersistenceService implements PersistenceService {
    private final String dataDir;
    private final String txFile;
    private final String budgetFile;

    public FilePersistenceService() {
        this("data/");
    }

    public FilePersistenceService(String dataDir) {
        this.dataDir = dataDir;
        this.txFile = dataDir + "transactions.csv";
        this.budgetFile = dataDir + "budgets.csv";

        File dir = new File(this.dataDir);
        if (!dir.exists()) dir.mkdirs();
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) {
        try (PrintWriter out = new PrintWriter(new FileWriter(txFile))) {
            for (Transaction t : transactions) {
                String safeDesc = t.getDescription().replace(",", " ");
                String safeCat = t.getCategory().replace(",", " ");
                out.printf("%s,%s,%s,%s,%s,%s%n",
                        t.getId(), t.getDate(), safeDesc,
                        t.getAmount(), safeCat, t.getType());
            }
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
        }
    }

    @Override
    public List<Transaction> loadTransactions() {
        List<Transaction> list = new ArrayList<>();
        File file = new File(txFile);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    list.add(new Transaction(
                            parts[0],
                            LocalDate.parse(parts[1]),
                            parts[2],
                            new BigDecimal(parts[3]),
                            parts[4],
                            TransactionType.valueOf(parts[5])
                    ));
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading transactions: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void saveBudgets(List<Budget> budgets) {
        try (PrintWriter out = new PrintWriter(new FileWriter(budgetFile))) {
            for (Budget b : budgets) {
                String safeCat = b.getCategory().replace(",", " ");
                out.printf("%s,%s%n", safeCat, b.getLimit());
            }
        } catch (IOException e) {
            System.err.println("Error saving budgets: " + e.getMessage());
        }
    }

    @Override
    public List<Budget> loadBudgets() {
        List<Budget> list = new ArrayList<>();
        File file = new File(budgetFile);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    list.add(new Budget(parts[0], new BigDecimal(parts[1])));
                }
            }
        } catch (Exception e) {
            System.err.println("Error loading budgets: " + e.getMessage());
        }
        return list;
    }
}
