# MicroStamp-Step1
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `microstamp.step1.Step1Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

The application will start by default in localhost:8080.

The project has swagger support, available at: localhost:8080/swagger-ui/index.html

There is a route for guests without authentication with some models for visualization: localhost:8080/guests
