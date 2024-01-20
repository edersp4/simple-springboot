package com.simple.simplespringboot.controller;

import com.simple.simplespringboot.exceptions.RequiredException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/greet")
    public String greet() {
        log.info("Hello, welcome to Spring Boot REST API!");
        return "Hello, welcome to Spring Boot REST API!";
    }

    @GetMapping("/echo")
    public String echo(@RequestParam String message) {
        log.info("Echoing message: {}", message);
        return message;
    }


    @GetMapping("/square")
    public int square(@RequestParam(required = false) Integer number) {
        if (Objects.isNull(number)) {
            log.error("Number cannot be null");
            throw new RequiredException("Number cannot be null");
        }
        final var result = number * number;
        log.info("Square of {} is {}", number, result);
        return result;
    }
}
