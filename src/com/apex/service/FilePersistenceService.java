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
    private static final String DATA_DIR = "data/";
    private static final String TX_FILE = DATA_DIR + "transactions.csv";
    private static final String BUDGET_FILE = DATA_DIR + "budgets.csv";

    public FilePersistenceService() {
        File dir = new File(DATA_DIR);
        if (!dir.exists()) dir.mkdirs();
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) {
        try (PrintWriter out = new PrintWriter(new FileWriter(TX_FILE))) {
            for (Transaction t : transactions) {
                out.printf("%s,%s,%s,%s,%s,%s%n",
                        t.getId(), t.getDate(), t.getDescription(),
                        t.getAmount(), t.getCategory(), t.getType());
            }
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
        }
    }

    @Override
    public List<Transaction> loadTransactions() {
        List<Transaction> list = new ArrayList<>();
        File file = new File(TX_FILE);
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
        try (PrintWriter out = new PrintWriter(new FileWriter(BUDGET_FILE))) {
            for (Budget b : budgets) {
                out.printf("%s,%s%n", b.getCategory(), b.getLimit());
            }
        } catch (IOException e) {
            System.err.println("Error saving budgets: " + e.getMessage());
        }
    }

    @Override
    public List<Budget> loadBudgets() {
        List<Budget> list = new ArrayList<>();
        File file = new File(BUDGET_FILE);
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
