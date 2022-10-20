# Spring Native Demo

## Prerequisites

Java 17 (with Graal VM 22)

## How To Run

To run the application you need a running instance of MySql 5.  
One can be started with docker:
```shell
docker run --name test-mysql-5 -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:5
```

Then build the application:
```shell
./mvnw -Pnative clean package
```

Then run the application:
```shell
./target/native-demo
```