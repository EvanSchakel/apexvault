## 2024-05-06 - Optimize FinanceManager getTotalBalance single pass
**Learning:** Single-pass imperative loops can significantly outperform Java Streams for collection iterations by avoiding stream setup overhead and duplicate traversals.
**Action:** When calculating multiple aggregates from a single collection, consider using a single imperative loop instead of multiple stream operations.
## 2026-05-16 - Optimize BigDecimal aggregation by avoiding Streams
**Learning:** In this codebase, single-pass imperative loops have lower overhead and are faster than the Java Streams API for iterating over collections and aggregating BigDecimal values.
**Action:** Prefer imperative loops with Map.merge() over Stream API and Collectors.groupingBy for performance-critical aggregations.
