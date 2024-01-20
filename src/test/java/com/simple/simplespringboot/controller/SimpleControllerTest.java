package com.simple.simplespringboot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SimpleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGreetEndpoint() throws Exception {
        this.mockMvc.perform(get("/api/greet"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hello, welcome to Spring Boot REST API!"));

    }

    @Test
    void echo() throws Exception {
        this.mockMvc.perform(get("/api/echo?message=teste"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("teste"));
    }

    @Test
    void square() throws Exception {
        this.mockMvc.perform(get("/api/square?number=3"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("9"));
    }

    @Test
    void testSquareWithoutParamValue() throws Exception {
        this.mockMvc.perform(get("/api/square"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().string("Number cannot be null"));
    }

    @Test
    void testSquareWithNANParamValue() throws Exception {
        this.mockMvc.perform(get("/api/square?number=abc"))
                    .andExpect(status().isBadRequest());

    }
}