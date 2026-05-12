## 2024-05-06 - Optimize FinanceManager getTotalBalance single pass
**Learning:** Single-pass imperative loops can significantly outperform Java Streams for collection iterations by avoiding stream setup overhead and duplicate traversals.
**Action:** When calculating multiple aggregates from a single collection, consider using a single imperative loop instead of multiple stream operations.

## 2026-05-12 - Java Streams vs Imperative Loop for Aggregation
**Learning:** Using Java Streams for filtering and aggregating collections (e.g. Map.merge for BigDecimals) introduces significant overhead compared to a single-pass imperative loop.
**Action:** Default to imperative loops for simple iterations and aggregations when performance is critical.
