## 2024-05-06 - Optimize FinanceManager getTotalBalance single pass
**Learning:** Single-pass imperative loops can significantly outperform Java Streams for collection iterations by avoiding stream setup overhead and duplicate traversals.
**Action:** When calculating multiple aggregates from a single collection, consider using a single imperative loop instead of multiple stream operations.
## 2026-05-17 - Faster CSV Serialization in Java
**Learning:** Using PrintWriter.printf() for simple CSV dumping is highly unoptimized due to regex and formatting overhead. Direct string concatenation with BufferedWriter is approximately 2-3x faster.
**Action:** Prefer string concatenation with BufferedWriter over String.format/printf for simple, high-volume file writing operations where performance matters.
