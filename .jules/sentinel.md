## 2026-05-14 - CSV Injection
**Vulnerability:** Unescaped CSV writing in custom persistence service allows structural breakage and CSV Injection.
**Learning:** The simple split-by-comma logic was susceptible to breakage and spreadsheet formulas weren't neutered.
**Prevention:** Replace structural characters and prepend a single quote to injection payloads.
