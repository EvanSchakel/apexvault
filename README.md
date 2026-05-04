## ApexVault

![CI](https://github.com/EvanSchakel/apexvault/actions/workflows/java-ci.yml/badge.svg)
![Release](https://img.shields.io/github/v/release/EvanSchakel/apexvault)
![License](https://img.shields.io/github/license/EvanSchakel/apexvault)

Terminal-first personal finance manager implemented in Java (JDK 17+).

Key features: transaction logging, CSV-backed persistence, category budgets, and a colorful terminal dashboard.

Prerequisites
- Java Development Kit (JDK) 17 or newer
- GNU Make (optional) or bash

Quick start

Using Make (recommended):

```bash
make run
```

Create a runnable JAR:

```bash
make package
# output: dist/apexvault-0.1.0.jar
```

Using the bundled script:

```bash
./run.sh
```

Manual (javac/java):

```bash
javac -d bin $(find src -name "*.java")
java -cp bin com.apex.Main
```

Project layout

- `src/` — Java sources under `com.apex.*`
- `data/` — CSV files used for persistence (`transactions.csv`, `budgets.csv`)

CI

This repository includes a GitHub Actions workflow (`.github/workflows/java-ci.yml`) that compiles the sources with JDK 17 and performs a smoke run. There is also a release workflow that packages a runnable JAR and attaches it to releases.

Persistence

Data is persisted as CSV files via the `FilePersistenceService` into the `data/` folder. Keep backups if you plan to modify the format.

License

This project is available under the MIT License; see the `LICENSE` file.

Contributing

Feel free to open issues or pull requests. See `CONTRIBUTING.md` for details.

