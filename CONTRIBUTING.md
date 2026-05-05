# Contributing to ApexVault

First off, thank you for considering contributing to ApexVault! It's people like you that make open-source software such a great community.

## 🤝 How Can I Contribute?

### Reporting Bugs
If you find a bug, please use the Bug Report issue template to report it. Ensure you provide clear steps to reproduce the issue, expected behavior, and actual behavior.

### Suggesting Enhancements
Have an idea for a new feature? Use the Feature Request issue template. Detail what you want to achieve and why it would be beneficial to the project.

### Code Contributions
We welcome code contributions! Whether it's a bug fix, new feature, or performance improvement.

## 💻 Development Setup

To start developing ApexVault locally:

1. **Prerequisites:** Make sure you have JDK 17+ and optionally GNU Make installed.
2. **Clone the repo:** `git clone https://github.com/EvanSchakel/apexvault.git`
3. **Branch:** Create your feature branch (`git checkout -b feature/AmazingFeature`)
4. **Compile & Run:**
    * Using Make: `make run`
    * Using Maven: `mvn clean compile exec:java -Dexec.mainClass="com.apex.Main"`
5. **Test:** Run the tests to make sure everything works (`mvn clean test`).

## ✅ Pull Request Process

1. Ensure your code follows the existing style guidelines of the project.
2. Update the `README.md` and any relevant documentation if your changes affect the interface, features, or project dependencies.
3. Your pull request should pass all existing tests. If you are adding new functionality, please include tests where appropriate.
4. Open a Pull Request! The CI pipeline will automatically run to verify your code compiles and tests pass.

## 📜 Code of Conduct

Please note that this project is released with a [Contributor Code of Conduct](CODE_OF_CONDUCT.md). By participating in this project you agree to abide by its terms.
