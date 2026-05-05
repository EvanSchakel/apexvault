package com.apex.service;

import com.apex.model.Transaction;
import com.apex.model.TransactionType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FilePersistenceServiceTest {

    private FilePersistenceService service;
    private final String DATA_DIR = "test-data/";
    private final String TX_FILE = DATA_DIR + "transactions.csv";
    private final String BUDGET_FILE = DATA_DIR + "budgets.csv";

    @BeforeEach
    void setUp() {
        // Clean up data dir before tests
        new File(TX_FILE).delete();
        new File(BUDGET_FILE).delete();
        new File(DATA_DIR).delete();
        service = new FilePersistenceService(DATA_DIR);
    }

    @AfterEach
    void tearDown() {
        // Clean up after tests
        new File(TX_FILE).delete();
        new File(BUDGET_FILE).delete();
        new File(DATA_DIR).delete();
    }

    @Test
    void testCsvEscaping() {
        Transaction txWithCommas = new Transaction(
                "abc12345",
                LocalDate.now(),
                "Bought some apples, oranges, and bananas",
                new BigDecimal("12.50"),
                "Groceries, Food",
                TransactionType.EXPENSE
        );

        service.saveTransactions(List.of(txWithCommas));

        List<Transaction> loaded = service.loadTransactions();
        assertFalse(loaded.isEmpty());
        Transaction loadedTx = loaded.get(0);

        // Commas should be replaced by spaces
        assertEquals("Bought some apples  oranges  and bananas", loadedTx.getDescription());
        assertEquals("Groceries  Food", loadedTx.getCategory());
        assertEquals(0, loadedTx.getAmount().compareTo(new BigDecimal("12.50")));
    }
}
