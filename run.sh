#!/bin/bash

# ApexVault Build & Run Script
# Designed for quick local execution

echo "--- Building ApexVault ---"
mkdir -p bin
javac -d bin src/com/apex/**/*.java src/com/apex/*.java

if [ $? -eq 0 ]; then
    echo "--- Launching Engine ---"
    java -cp bin com.apex.Main
else
    echo "Build Failed. Please check JDK installation."
fi
