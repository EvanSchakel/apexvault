package com.apex;

import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import com.apex.service.FilePersistenceService;
import com.apex.service.FinanceManager;
import com.apex.service.PersistenceService;
import com.apex.ui.TerminalUI;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersistenceService persistence = new FilePersistenceService();
        FinanceManager manager = new FinanceManager(persistence);
        TerminalUI ui = new TerminalUI();
        Scanner scanner = new Scanner(System.in);

        ui.printHeader();

        while (true) {
            ui.printMenu();
            String input = scanner.nextLine();

            try {
                switch (input) {
                    case "1":
                        ui.printDashboard(manager.getTotalBalance(), manager.getSpendingByCategory(), manager.getAllBudgets());
                        break;
                    case "2":
                        logTransaction(scanner, ui, manager, TransactionType.INCOME);
                        break;
                    case "3":
                        logTransaction(scanner, ui, manager, TransactionType.EXPENSE);
                        break;
                    case "4":
                        setBudget(scanner, ui, manager);
                        break;
                    case "5":
                        ui.printTransactions(manager.getAllTransactions());
                        break;
                    case "0":
                        System.out.println("Powering down ApexVault. Secure your assets.");
                        return;
                    default:
                        ui.showError("Unknown command.");
                }
            } catch (Exception e) {
                ui.showError("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void logTransaction(Scanner sc, TerminalUI ui, FinanceManager manager, TransactionType type) {
        System.out.print("Amount: ");
        BigDecimal amount = new BigDecimal(sc.nextLine());
        System.out.print("Category: ");
        String cat = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();

        manager.addTransaction(new Transaction(LocalDate.now(), desc, amount, cat, type));
        ui.showSuccess("Transaction logged.");
    }

    private static void setBudget(Scanner sc, TerminalUI ui, FinanceManager manager) {
        System.out.print("Category: ");
        String cat = sc.nextLine();
        System.out.print("Monthly Limit: ");
        BigDecimal limit = new BigDecimal(sc.nextLine());

        manager.setBudget(cat, limit);
        ui.showSuccess("Budget updated for " + cat);
    }
}
