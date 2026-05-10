## 2024-05-06 - Optimize FinanceManager getTotalBalance single pass
**Learning:** Single-pass imperative loops can significantly outperform Java Streams for collection iterations by avoiding stream setup overhead and duplicate traversals.
**Action:** When calculating multiple aggregates from a single collection, consider using a single imperative loop instead of multiple stream operations.
## 2024-05-10 - Stream overhead with Collectors.groupingBy and BigDecimal
**Learning:** Using `Collectors.groupingBy` with `Collectors.reducing` and `BigDecimal::add` in Java Streams has noticeable performance overhead compared to a simple imperative loop with `Map.merge(key, value, BigDecimal::add)`, reducing processing time by over 30% for a large number of transactions.
**Action:** When aggregating records (like grouping by string key and reducing `BigDecimal`), use `Map.merge()` inside an imperative loop for faster execution and lower memory allocation overhead.
