package com.apex.model;

import java.math.BigDecimal;

public class Budget {
    private final String category;
    private final BigDecimal limit;

    public Budget(String category, BigDecimal limit) {
        this.category = category;
        this.limit = limit;
    }

    public String getCategory() { return category; }
    public BigDecimal getLimit() { return limit; }
}
