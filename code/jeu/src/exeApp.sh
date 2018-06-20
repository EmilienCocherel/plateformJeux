rm  application/*.class
rm  mastermind/*.class
rm  connect4/*.class
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar mastermind/*.java
javac -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar connect4/*.java
jar -cvf connect4.jar connect4/*.class connect4/style/style.css
jar -cvf mastermind.jar mastermind/*.class
#mysql -h servinfo-db -u $2 -D $1 -p $3 -e "delete from PARTIE"
#mysql -h servinfo-db -u $2 -D $1 -p $3 -e "delete from JEU"
mysql -h servinfo-db -u charlotte -D dbcharlotte -p -e "delete from PARTIE"
mysql -h servinfo-db -u charlotte -D dbcharlotte -p -e "delete from JEU"
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.MettreJeuDansBD servinfo-db "$1" "$2" "$3" mastermind mastermind.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db "$1" "$2" "$3" mastermind jar/mastermind.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.MettreJeuDansBD servinfo-db "$1" "$2" "$3" connect4 connect4.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.TelechargerJeu servinfo-db "$1" "$2" "$3" connect4 jar/connect4.jar
java -cp .:/pub/1A/json-simple.jar:/usr/share/java/mysql.jar application.AppliJDBC
