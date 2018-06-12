#!/bin/bash
export CLASSPATH=$CLASSPATH:./bin
if [ -f Connect4.jar ]; then
	rm Connect4.jar
fi
javac -d ./ src/*.java
if (( $? == 0 )); then
	jar cfe Connect4.jar GUI *.class style/style.css
	rm *.class
	java -jar Connect4.jar
fi
