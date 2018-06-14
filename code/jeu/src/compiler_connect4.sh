#!/bin/bash
javac connect4/*.java
jar -cvfm connect4.jar connect4/Manifest.txt connect4/*.class connect4/style/style.css
rm connect4/*.class
