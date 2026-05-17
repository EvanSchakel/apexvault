## 2026-05-17 - CSV Injection and Structure Breakage Fix
**Vulnerability:** Unsanitized user inputs written to CSV, leading to formula injection risks (if opened in Excel) and file format corruption (if input contains commas/newlines).
**Learning:** ApexVault writes CSVs manually with `String.format` / `printf` instead of using a library. Commas break `String.split(",")` on load.
**Prevention:** Prepend `'` to inputs starting with `=`, `+`, `-`, or `@`. Replace `,` and `\n` in inputs with spaces.
