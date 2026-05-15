## 2024-05-19 - Division by Zero in BigDecimal UI Logic
**Vulnerability:** ArithmeticException due to Division by Zero during UI rendering when calculating progress bars with 0 limit budgets.
**Learning:** `BigDecimal.divide()` throws ArithmeticException if the divisor is zero, unlike floating point primitives which might result in Infinity or NaN.
**Prevention:** Always check `BigDecimal` divisors using `divisor.compareTo(BigDecimal.ZERO) == 0` before calling `divide()`.

## 2026-05-15 - CSV Injection & Structural Breakage
**Vulnerability:** The simplistic split by comma logic for parsing CSV allows commas in user input to break the CSV structure. Additionally, starting input with special characters can cause CSV Injection when viewed in Excel.
**Learning:** The lack of a robust CSV parsing library requires manual sanitization of user inputs.
**Prevention:** Sanitize CSV fields by replacing structural delimiters (like commas and newlines) with spaces, and prepending a single quote to inputs starting with '=', '+', '-', or '@'.
