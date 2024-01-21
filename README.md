# Simple Spring Boot Application V1.0.0

Author Ederson da Silva

This is a simple Spring Boot application.

## Prerequisites

- Java 17
- Maven
- Docker

## The Application uses the following technologies

- Spring Boot 3.2.2
- H2 Database
- Swagger 3.0.0
- Lombok 1.18.22
- Mapstruct 1.4.2
- JUnit 5
- Mockito 3.12.4

## Building the Application

To build the application, run the following command in the project root directory:

```bash
mvn clean package
```

This will create an executable JAR file in the target directory.

Building the Docker Image

```bash
docker build -t simple-spring-boot-app .
```

To run the docker image

```bash
docker run -p 8080:8080 simple-spring-boot-app
```

This application will populate the database with some users data on startup.

## Api Documentation

To view the api documentation, run the application and navigate to the following URLs:

Swagger UI: http://localhost:8080/swagger-ui.html

JSON: http://localhost:8080/v3/api-docs

## Database H2 Console

To view the database console, run the application and navigate to the following URL:

Database H2 Console: http://localhost:8080/h2-console

### Database H2 Console Configuration

url: jdbc:h2:mem:testdb

username: sa

password: sa

## Code Review

### In the class DatabaseSeeder.java should be replaced for flyway framework to manage the database migrations and populate the database with some sample users data on startup.

```java

package com.simple.simplespringboot;

import com.simple.simplespringboot.model.User;
import com.simple.simplespringboot.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseSeeder implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.save(new User(1L, "John Doe"));
        this.userRepository.save(new User(2L, "Jane Doe"));
        this.userRepository.save(new User(3L, "Foo Bar"));
    }
}


```

### In the class ControllerExceptionHandler.java should add more exceptions to handle the errors to return the correct http status code to user.

```java

package com.simple.simplespringboot.config;

import com.simple.simplespringboot.exceptions.RequiredException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(RequiredException.class)
    public ResponseEntity<String> handleIllegalArgumentException(RequiredException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

```

### Create new environment to run the application in qa,development and production mode.

### Create integration tests to test the application.

