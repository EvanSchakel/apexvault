.PHONY: build run package clean

VERSION ?= 0.1.0

build:
	mkdir -p bin
	javac -d bin $(shell find src -name "*.java")

package: build
	mkdir -p dist
	printf "Main-Class: com.apex.Main\n" > manifest.txt
		jar cfm dist/apexvault-$(VERSION).jar manifest.txt -C bin .
	rm -f manifest.txt
	ls -lh dist/apexvault-$(VERSION).jar

maven-package:
	mvn -B package
	mkdir -p dist
	cp target/*.jar dist/ || true

run: build
	echo 0 | java -cp bin com.apex.Main

clean:
	rm -rf bin dist
