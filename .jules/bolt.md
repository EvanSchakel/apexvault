## 2024-05-24 - Avoid Streams for simple aggregations
**Learning:** Single-pass imperative loops are significantly faster and have lower overhead compared to using the Java Streams API for iterating over collections in this environment.
**Action:** Use single-pass imperative loops instead of Java Streams for simple collection aggregations in performance-critical paths.
