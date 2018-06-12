#!/bin/bash
export CLASSPATH=$CLASSPATH:./bin
if [ -f Connect4.jar ]; then
	rm Connect4.jar
fi
mkdir -p bin
javac -d bin src/*.java
if (( $? == 0 )); then
	cd bin
	jar cfe ../Connect4.jar GUI *.class
	cd ..
	java -jar Connect4.jar
fi
