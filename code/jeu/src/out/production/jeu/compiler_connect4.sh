#!/bin/bash
javac connect4/*.java
jar -cvf connect4.jar connect4/*.class connect4/style/style.css
