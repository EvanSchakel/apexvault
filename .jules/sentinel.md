## 2026-05-18 - Prevent CSV Injection and Structural Breakage
**Vulnerability:** User inputs containing commas could break CSV structure, and inputs starting with =, +, -, @ could lead to CSV injection when exported and opened in spreadsheet software.
**Learning:** The application parses CSV with simple `String.split(",")` and doesn't support escaping. Directly writing user input without sanitization is a severe vulnerability for both data integrity and security.
**Prevention:** Prepend a single quote to fields starting with dangerous characters, and replace commas/newlines with spaces to preserve the structure.
