## 2024-05-19 - Division by Zero in BigDecimal UI Logic
**Vulnerability:** ArithmeticException due to Division by Zero during UI rendering when calculating progress bars with 0 limit budgets.
**Learning:** `BigDecimal.divide()` throws ArithmeticException if the divisor is zero, unlike floating point primitives which might result in Infinity or NaN.
**Prevention:** Always check `BigDecimal` divisors using `divisor.compareTo(BigDecimal.ZERO) == 0` before calling `divide()`.
## 2026-05-10 - CSV Injection and Structural Breakage due to Missing Escaping
**Vulnerability:** CSV injection and structural breakage when writing to CSV without proper escaping.
**Learning:** The application's reliance on custom String.split(",") for CSV parsing meant user input containing commas could shift columns and break parsing. Furthermore, lack of escaping for fields starting with =, +, -, or @ allowed potential CSV injection attacks if the file was opened in Excel.
**Prevention:** Whenever writing to CSV formats manually, always replace commas and newlines to prevent structural breakage, and prepend a single quote to fields starting with =, +, -, @ to prevent CSV injection. Better yet, use a dedicated CSV parsing/writing library.
