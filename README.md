<div align="center">
  <img src="https://via.placeholder.com/150" alt="ApexVault Logo" width="150"/>
  <h1>ApexVault</h1>
  <p>
    <strong>A lightning-fast, terminal-first personal finance manager.</strong>
  </p>
  <p>
    <a href="https://github.com/EvanSchakel/apexvault/actions/workflows/java-ci.yml"><img src="https://github.com/EvanSchakel/apexvault/actions/workflows/java-ci.yml/badge.svg" alt="CI Status"/></a>
    <a href="https://github.com/EvanSchakel/apexvault/releases"><img src="https://img.shields.io/github/v/release/EvanSchakel/apexvault" alt="Release"/></a>
    <a href="https://github.com/EvanSchakel/apexvault/blob/main/LICENSE"><img src="https://img.shields.io/github/license/EvanSchakel/apexvault" alt="License"/></a>
    <a href="https://github.com/EvanSchakel/apexvault/issues"><img src="https://img.shields.io/github/issues/EvanSchakel/apexvault" alt="Issues"/></a>
    <img src="https://img.shields.io/badge/Java-17%2B-ED8B00?logo=openjdk&logoColor=white" alt="Java 17+"/>
  </p>
</div>

<hr/>

## 📖 Overview

**ApexVault** is a robust, local-first personal finance manager designed exclusively for the terminal. Built for power users who value speed, privacy, and simplicity, ApexVault offers a dependable, highly-responsive way to manage transactions and budgets without the overhead of a web app.

Whether you're tracking daily expenses, monitoring category budgets, or reviewing monthly financial health, ApexVault provides a colorful, intuitive dashboard directly within your command line interface.

## ✨ Key Features

- **🚀 Lightning Fast:** Near-instant startup times and zero network latency.
- **🔒 Local & Private:** Your data stays on your machine. All persistence is handled locally via plain text CSV files.
- **📊 Intuitive Dashboard:** A colorful, feature-rich TUI (Terminal User Interface) providing immediate insights into your finances.
- **📝 Transaction Logging:** Easily record, categorize, and track income and expenses.
- **🎯 Category Budgets:** Set budget limits per category and track your progress throughout the month.
- **🛠️ Zero Dependencies:** Built with pure Java 17+, requiring minimal setup. No heavy databases or external services.

## 📸 Demo

*(Placeholder for future dashboard screenshots. Imagine a beautifully colored terminal interface with ASCII charts and clean tabular data!)*

```text
=========================================
            APEX VAULT DASHBOARD
=========================================
[+] Total Balance: $5,240.50
[~] Monthly Spending: $1,150.00 / $2,000.00 (57%)

Recent Transactions:
  2023-10-24 | Groceries      | -$124.50
  2023-10-23 | Salary         | +$3,200.00
  2023-10-21 | Internet Bill  | -$75.00
=========================================
```

## ⚙️ Architecture

ApexVault is designed with simplicity and reliability in mind.
- **Language:** Java 17+
- **Persistence:** `FilePersistenceService` reading/writing to local CSV files (`data/transactions.csv`, `data/budgets.csv`).
- **Design Pattern:** Modular CLI approach separating business logic from presentation.

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK) 17** or newer
- **GNU Make** (optional, but highly recommended) or **Bash**

### Installation & Usage

Clone the repository:
```bash
git clone https://github.com/EvanSchakel/apexvault.git
cd apexvault
```

#### Option 1: Using Make (Recommended)

Run the application directly:
```bash
make run
```

Package into a runnable JAR:
```bash
make package
# The artifact will be generated at dist/apexvault-0.1.0.jar
java -jar dist/apexvault-0.1.0.jar
```

#### Option 2: Using the Bundled Script

```bash
chmod +x run.sh
./run.sh
```

#### Option 3: Manual Compilation

```bash
# Compile
javac -d bin $(find src/main/java -name "*.java")

# Run
java -cp bin com.apex.Main
```

## 📁 Project Structure

```text
apexvault/
├── src/            # Java source files (com.apex.*)
├── data/           # Local CSV persistence files
├── docs/           # Documentation
├── scripts/        # Utility scripts
├── pom.xml         # Maven configuration
├── Makefile        # Build commands
└── run.sh          # Quick-run shell script
```

## 🤝 Contributing

We welcome contributions from everyone! Whether it's reporting a bug, suggesting a feature, or submitting a pull request, your help is appreciated.

Please see our [Contributing Guidelines](CONTRIBUTING.md) for details on how to get started, and make sure to review our [Code of Conduct](CODE_OF_CONDUCT.md).

## 🛡️ Security

If you discover a security vulnerability within ApexVault, please refer to our [Security Policy](SECURITY.md) for reporting instructions.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
<div align="center">
  <i>Built with ❤️ for the terminal.</i>
</div>
