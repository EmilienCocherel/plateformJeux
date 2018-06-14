javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar mastermind/*.java
jar -cvf morpion.jar mastermind/*.class
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.MettreJeuDansBD servinfo-db "$1" "$2" "$3" mastermind mastermind.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db "$1" "$2" "$3" mastermind jar/mastermind.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.AppliJDBC
