# Spring Native Demo

## Prerequisites

Java 17 (with Graal VM 22)

## How To Run

### Prerequisites

To run the application you need a running instance of MySql.  
One can be started with docker:
```shell
docker run --name test-mysql-8 -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:8
```

### Running as binary

Build the application:
```shell
./mvnw -Pnative clean package
```

Then run the application:
```shell
./target/native-demo
```

### Running as docker image

Build docker image
```shell
mvn -Pnative spring-boot:build-image
```

Run docker image
```shell
docker run -p 8080:8080 -e SPRING_DATASOURCE_URL='jdbc:mysql://host.docker.internal/test' native-demo:0.0.1-SNAPSHOT -rm
```