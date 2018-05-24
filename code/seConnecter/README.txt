javac -d ./bin ./src/*.java
java -cp bin:/usr/share/java/mysql.jar TestJDBC
javadoc -d doc src/*.java
