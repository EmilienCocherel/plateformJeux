javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar mastermind/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar connect4/*.java

jar -cvf morpion.jar mastermind/*.class
jar -cvf morpion.jar connect4/*.class
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db "$1" "$2" "$3" mastermind jar/mastermind.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db "$1" "$2" "$3" connect4 jar/connect4.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.AppliJDBC
