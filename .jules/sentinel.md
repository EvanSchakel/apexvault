## 2024-05-19 - Division by Zero in BigDecimal UI Logic
**Vulnerability:** ArithmeticException due to Division by Zero during UI rendering when calculating progress bars with 0 limit budgets.
**Learning:** `BigDecimal.divide()` throws ArithmeticException if the divisor is zero, unlike floating point primitives which might result in Infinity or NaN.
**Prevention:** Always check `BigDecimal` divisors using `divisor.compareTo(BigDecimal.ZERO) == 0` before calling `divide()`.
## 2026-05-12 - Prevent CSV Injection and Structural Breakage
**Vulnerability:** The application's manual CSV parsing logic uses a simple `String.split(",")` and does not escape special characters or commas. This allows for CSV injection attacks via fields starting with `=`, `+`, `-`, or `@` and structural breakage when a user inputs commas or newlines.
**Learning:** When generating CSVs manually without a standard library, input strings must be explicitly sanitized to ensure structural integrity and prevent injection.
**Prevention:** Replace commas, newlines, and carriage returns with spaces. Prepend a single quote (`'`) to any field that begins with CSV execution triggers (`=`, `+`, `-`, `@`).
