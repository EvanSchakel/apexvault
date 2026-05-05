package com.apex.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputHelper {

    public static BigDecimal readBigDecimal(Scanner sc, TerminalUI ui, String prompt, boolean allowNegative) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                BigDecimal value = new BigDecimal(input);
                if (!allowNegative && value.compareTo(BigDecimal.ZERO) < 0) {
                    ui.showError("Value cannot be negative. Please try again.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                ui.showError("Invalid number format. Please try again.");
            }
        }
    }

    public static String readString(Scanner sc, TerminalUI ui, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                ui.showError("Input cannot be empty. Please try again.");
            } else {
                return input;
            }
        }
    }

    public static LocalDate readDate(Scanner sc, TerminalUI ui, String prompt) {
        while (true) {
            System.out.print(prompt + " [Leave blank for today]: ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return LocalDate.now();
            }
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                ui.showError("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }
}
