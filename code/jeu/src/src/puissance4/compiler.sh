#!/bin/bash
export CLASSPATH=$CLASSPATH:./bin
if [ -f Connect4.jar ]; then
	rm Connect4.jar
fi
javac -d ./ src/*.java
if (( $? == 0 )); then
	jar -cvfm Connect4.jar Manifest.txt Connect4/*.class style/style.css
	rm -r Connect4/
fi
