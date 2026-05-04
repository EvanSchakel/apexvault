.PHONY: build run package clean

VERSION ?= 0.1.0

build:
	mkdir -p bin
	javac -d bin $(find src -name "*.java")

package: build
	mkdir -p dist
	printf "Main-Class: com.apex.Main\n" > manifest.txt
	jar cfm dist/apexvault-$(VERSION).jar manifest.txt -C bin .
	rm -f manifest.txt
	ls -lh dist/apexvault-$(VERSION).jar

run: build
	echo 0 | java -cp bin com.apex.Main

clean:
	rm -rf bin dist
