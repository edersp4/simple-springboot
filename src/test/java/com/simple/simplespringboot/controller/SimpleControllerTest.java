package com.simple.simplespringboot.controller;

import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("Test Greet Endpoint")
    @Test
    void testGreetEndpoint() throws Exception {
        this.mockMvc.perform(get("/api/greet"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("Hello, welcome to Spring Boot REST API!"));

    }

    @DisplayName("Test Echo Endpoint")
    @Test
    void echo() throws Exception {
        this.mockMvc.perform(get("/api/echo?message=teste"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("teste"));
    }

    @DisplayName("Test Square Endpoint with number 3")
    @Test
    void square() throws Exception {
        this.mockMvc.perform(get("/api/square?number=3"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("9"));
    }

    @DisplayName("Test Square Endpoint without param value")
    @Test
    void testSquareWithoutParamValue() throws Exception {
        this.mockMvc.perform(get("/api/square"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().string("Number cannot be null"));
    }

    @DisplayName("Test Square Endpoint with NAN param value")
    @Test
    void testSquareWithNANParamValue() throws Exception {
        this.mockMvc.perform(get("/api/square?number=abc"))
                    .andExpect(status().isBadRequest());

    }
}