javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar mastermind/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar connect4/*.java
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db dbcharlotte charlotte charlotte mastermind jar/mastermind.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db dbcharlotte charlotte charlotte connect4 jar/connect4.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.AppliJDBC
