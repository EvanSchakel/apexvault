## 2024-05-06 - Optimize FinanceManager getTotalBalance single pass
**Learning:** Single-pass imperative loops can significantly outperform Java Streams for collection iterations by avoiding stream setup overhead and duplicate traversals.
**Action:** When calculating multiple aggregates from a single collection, consider using a single imperative loop instead of multiple stream operations.

## 2026-05-19 - Optimize I/O serialization using BufferedWriter
**Learning:** For high-volume text or CSV serialization in Java, using `BufferedWriter` with direct string concatenation avoids significant performance overhead introduced by regex parsing and formatting in `PrintWriter.printf()` or `String.format()`.
**Action:** When serializing large collections to text files, prefer `BufferedWriter` and manual string building over format strings.
