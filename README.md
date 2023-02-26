# Hello Spark

### How to run

```shell
mvn clean compile assembly:single
docker compose down
docker compose up -d
clear
java -jar ./target/hello-spark-1.0-jar-with-dependencies.jar

```

Now open http://localhost:8080/ and go to completed app, open stdout panel.
