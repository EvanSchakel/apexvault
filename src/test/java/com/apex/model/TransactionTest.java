package com.apex.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransactionTest {

    @Test
    void testToStringIncome() {
        Transaction transaction = new Transaction("tx-12345", LocalDate.of(2023, 10, 27), "Salary", new BigDecimal("5000.00"), "Income", TransactionType.INCOME);
        String expected = "[tx-12345] 2023-10-27: + 5000.00 (Income)";
        assertEquals(expected, transaction.toString());
    }

    @Test
    void testToStringExpense() {
        Transaction transaction = new Transaction("tx-67890", LocalDate.of(2023, 10, 28), "Groceries", new BigDecimal("150.50"), "Food", TransactionType.EXPENSE);
        String expected = "[tx-67890] 2023-10-28: - 150.50 (Food)";
        assertEquals(expected, transaction.toString());
    }
}
