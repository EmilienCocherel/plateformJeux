#!/bin/bash
mkdir -p bin
javac -d bin src/*.java
cd bin
jar cfe ../Connect4.jar GUI *.class
cd ..
java -jar Connect4.jar
