## 2024-05-19 - Division by Zero in BigDecimal UI Logic
**Vulnerability:** ArithmeticException due to Division by Zero during UI rendering when calculating progress bars with 0 limit budgets.
**Learning:** `BigDecimal.divide()` throws ArithmeticException if the divisor is zero, unlike floating point primitives which might result in Infinity or NaN.
**Prevention:** Always check `BigDecimal` divisors using `divisor.compareTo(BigDecimal.ZERO) == 0` before calling `divide()`.
## 2026-05-16 - CSV Injection and Structural Breakage in Manual Parsing
**Vulnerability:** User inputs containing commas, newlines, or formula characters (=, +, -, @) can break structural integrity or inject malicious formulas when using simple String.split and PrintWriter for CSV persistence.
**Learning:** Manual CSV building without an established library must manually sanitize delimiters, line breaks, and formula prefixes.
**Prevention:** Always replace structural characters (e.g. commas and newlines) and prepend a single quote to formula prefixes to prevent CSV injection.
