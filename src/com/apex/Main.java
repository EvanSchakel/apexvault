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
import com.apex.ui.InputHelper;

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
                    case "6":
                        printHelp();
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

    private static void printHelp() {
        System.out.println("\n--- APEX VAULT HELP ---");
        System.out.println("1. View Dashboard      : Displays total balance and progress bars for budgets.");
        System.out.println("2. Log Income          : Adds an income transaction. Enter positive amounts.");
        System.out.println("3. Log Expense         : Adds an expense transaction. Enter positive amounts.");
        System.out.println("4. Set Category Budget : Sets a maximum monthly limit for a specific category.");
        System.out.println("5. Transaction History : Shows all logged transactions.");
        System.out.println("6. Help                : Shows this help screen.");
        System.out.println("0. Exit                : Closes the application safely.");
    }

    private static void logTransaction(Scanner sc, TerminalUI ui, FinanceManager manager, TransactionType type) {
        BigDecimal amount = InputHelper.readBigDecimal(sc, ui, "Amount: ", false);
        String cat = InputHelper.readString(sc, ui, "Category: ");
        String desc = InputHelper.readString(sc, ui, "Description: ");
        LocalDate date = InputHelper.readDate(sc, ui, "Date");

        manager.addTransaction(new Transaction(date, desc, amount, cat, type));
        ui.showSuccess("Transaction logged.");
    }

    private static void setBudget(Scanner sc, TerminalUI ui, FinanceManager manager) {
        String cat = InputHelper.readString(sc, ui, "Category: ");
        BigDecimal limit = InputHelper.readBigDecimal(sc, ui, "Monthly Limit: ", false);

        manager.setBudget(cat, limit);
        ui.showSuccess("Budget updated for " + cat);
    }
}
