package com.apex.ui;

import com.apex.model.Budget;
import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class TerminalUI {
    // ANSI Colors
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";

    public void printHeader() {
        System.out.println(CYAN + BOLD);
        System.out.println("   ▲ P E X   V A U L T   ");
        System.out.println("   Personal Finance Orchestrator");
        System.out.println(RESET);
    }

    public void printMenu() {
        System.out.println(BOLD + "--- COMMAND CENTER ---" + RESET);
        System.out.println("1. View Dashboard");
        System.out.println("2. Log Income");
        System.out.println("3. Log Expense");
        System.out.println("4. Set Category Budget");
        System.out.println("5. Transaction History");
        System.out.println("0. Exit");
        System.out.print(YELLOW + "\nAction > " + RESET);
    }

    public void printDashboard(BigDecimal balance, Map<String, BigDecimal> spending, List<Budget> budgets) {
        System.out.println("\n" + PURPLE + BOLD + "=== SYSTEM DASHBOARD ===" + RESET);
        System.out.printf("Current Net Balance: %s$%,.2f%s\n", (balance.compareTo(BigDecimal.ZERO) >= 0 ? GREEN : RED), balance, RESET);
        
        System.out.println("\n--- Budget Status ---");
        if (budgets.isEmpty()) {
            System.out.println("No budgets defined. Use option [4] to set a category budget.");
        } else {
            for (Budget b : budgets) {
                BigDecimal spent = spending.getOrDefault(b.getCategory(), BigDecimal.ZERO);
                printProgressBar(b.getCategory(), spent, b.getLimit());
            }
        }
        System.out.println();
    }

    private void printProgressBar(String label, BigDecimal spent, BigDecimal limit) {
        double percent = 0.0;
        if (limit.compareTo(BigDecimal.ZERO) == 0) {
            percent = spent.compareTo(BigDecimal.ZERO) > 0 ? 1.0 : 0.0;
        } else {
            percent = spent.divide(limit, 4, RoundingMode.HALF_UP).doubleValue();
        }

        int bars = (int) (percent * 20);
        if (bars > 20) bars = 20;

        String color = percent > 0.9 ? RED : (percent > 0.7 ? YELLOW : GREEN);
        
        System.out.printf("%-12s ", label);
        System.out.print("[");
        for (int i = 0; i < 20; i++) {
            if (i < bars) System.out.print(color + "■" + RESET);
            else System.out.print(" ");
        }
        System.out.print("]");
        System.out.printf(" %d%% ($%,.0f / $%,.0f)\n", (int)(percent * 100), spent, limit);
    }

    public void printTransactions(List<Transaction> transactions) {
        System.out.println("\n" + CYAN + "ID       DATE       TYPE     AMOUNT     CATEGORY    DESC" + RESET);
        System.out.println("------------------------------------------------------------------");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found. Use option [2] or [3] to log one.");
            return;
        }
        for (Transaction t : transactions) {
            String typeColor = t.getType() == TransactionType.INCOME ? GREEN : RED;
            System.out.printf("%-8s %-10s %-8s %s$%,8.2f%s %-11s %s\n",
                    t.getId(), t.getDate(), t.getType(), 
                    typeColor, t.getAmount(), RESET,
                    t.getCategory(), t.getDescription());
        }
    }

    public void showSuccess(String msg) {
        System.out.println(GREEN + "✔ " + msg + RESET);
    }

    public void showError(String msg) {
        System.out.println(RED + "✘ ERROR: " + msg + RESET);
    }
}
