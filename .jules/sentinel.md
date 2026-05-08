## 2024-05-19 - Division by Zero in BigDecimal UI Logic
**Vulnerability:** ArithmeticException due to Division by Zero during UI rendering when calculating progress bars with 0 limit budgets.
**Learning:** `BigDecimal.divide()` throws ArithmeticException if the divisor is zero, unlike floating point primitives which might result in Infinity or NaN.
**Prevention:** Always check `BigDecimal` divisors using `divisor.compareTo(BigDecimal.ZERO) == 0` before calling `divide()`.
