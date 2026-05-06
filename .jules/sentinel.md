## 2024-05-15 - Prevent CSV Injection and Information Exposure

**Vulnerability:** CSV Injection and Information Exposure
**Learning:** Writing unsanitized input to CSV files can cause the structure to break (via commas or newlines) or lead to malicious command execution in spreadsheet applications (via formula injection `=, +, -, @`). In addition, logging raw exception messages (like `e.getMessage()`) to user-facing or standard logs can leak sensitive internal system information to potential attackers.
**Prevention:** Sanitize data before persisting it to CSV by removing/replacing delimiter characters (like commas and newlines) and prepending a single quote (`'`) to fields starting with `=, +, -, @, \t, \r`. Always use generic, sanitized error messages when catching and logging exceptions.
