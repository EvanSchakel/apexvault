package com.apex.service;

import com.apex.ui.TerminalUI;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class ManualFunctionalTest {
    public static void main(String[] args) {
        TerminalUI ui = new TerminalUI();

        System.out.println("Testing printDashboard with empty budgets:");
        ui.printDashboard(BigDecimal.ZERO, new HashMap<>(), new ArrayList<>());

        System.out.println("Testing printTransactions with empty transactions:");
        ui.printTransactions(new ArrayList<>());

        System.out.println("\nManual test completed. Please verify the output manually for actionable empty state messages.");
    }
}
