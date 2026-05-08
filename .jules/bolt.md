## 2024-05-06 - Optimize FinanceManager getTotalBalance single pass
**Learning:** Single-pass imperative loops can significantly outperform Java Streams for collection iterations by avoiding stream setup overhead and duplicate traversals.
**Action:** When calculating multiple aggregates from a single collection, consider using a single imperative loop instead of multiple stream operations.
