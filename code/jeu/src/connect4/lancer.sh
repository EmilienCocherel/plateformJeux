#!/bin/bash
if [ -f Connect4.jar ]; then
	rm Connect4.jar
fi
javac -d ./ *.java
if (( $? == 0 )); then
	jar cfme Connect4.jar Manifest.txt Connect4.LeJeu Connect4/*.class style/style.css
	rm -r Connect4/
	java -jar Connect4.jar
fi
