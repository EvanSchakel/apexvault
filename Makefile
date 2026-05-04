.PHONY: build run clean

build:
	mkdir -p bin
	javac -d bin $(find src -name "*.java")

run: build
	echo 0 | java -cp bin com.apex.Main

clean:
	rm -rf bin dist
