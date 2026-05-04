## ApexVault

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

This repository includes a GitHub Actions workflow (`.github/workflows/java-ci.yml`) that compiles the sources with JDK 17 and performs a smoke run.

Persistence

Data is persisted as CSV files via the `FilePersistenceService` into the `data/` folder. Keep backups if you plan to modify the format.

License

This project is available under the MIT License; see the `LICENSE` file.

Contributing

Feel free to open issues or pull requests. If you plan to publish this repository, you can use the `gh` CLI (GitHub) or create the repo manually, then push the changes.

