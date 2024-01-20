package com.simple.simplespringboot.controller;

import com.simple.simplespringboot.exceptions.RequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello, welcome to Spring Boot REST API!";
    }

    @GetMapping("/echo")
    public String echo(@RequestParam String message) {
        return message;
    }


    @GetMapping("/square")
    public int square(@RequestParam(required = false) Integer number) {
        if (Objects.isNull(number))
            throw new RequiredException("Number cannot be null");
        return number * number;
    }
}
