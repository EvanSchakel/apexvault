## 2024-05-18 - Fix Division by Zero in TerminalUI
**Vulnerability:** ArithmeticException (Division by zero) in TerminalUI's printProgressBar method when budget limit is zero.
**Learning:** Dividing by a BigDecimal that is zero throws an ArithmeticException, which can lead to Denial of Service (app crash) if unchecked.
**Prevention:** Check if the divisor (`limit`) is zero using `limit.compareTo(BigDecimal.ZERO) == 0` before attempting the division.
