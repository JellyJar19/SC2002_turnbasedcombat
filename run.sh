#!/bin/bash

# Minimum required Java version
REQUIRED_VERSION=11

# Check Java is installed
if ! command -v java &> /dev/null; then
    echo "ERROR: Java is not installed. Please install JDK $REQUIRED_VERSION or higher."
    exit 1
fi

# Get current Java version
JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d'.' -f1)

# Check version is sufficient
if [ "$JAVA_VERSION" -lt "$REQUIRED_VERSION" ]; then
    echo "ERROR: Java $REQUIRED_VERSION or higher is required. You have Java $JAVA_VERSION."
    exit 1
fi

echo "Using Java $JAVA_VERSION"

# Clean and recompile
rm -rf bin/*
mkdir -p bin

# --release 11 ensures consistent bytecode regardless of compiler version
javac --release 11 -d bin $(find src -name "*.java")

if [ $? -ne 0 ]; then
    echo "ERROR: Compilation failed."
    exit 1
fi

echo "Compilation successful. Running..."
java -cp bin mainMenu.UI
