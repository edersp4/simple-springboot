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
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        String json = """
                  [
                    {
                        "id": 1,
                        "name": "John Doe"
                    },
                    {
                        "id": 2,
                        "name": "Jane Doe"
                    },
                    {
                        "id": 3,
                        "name": "Foo Bar"
                    }
                ]
                """;
        this.mockMvc.perform(get("/api/users"))
                    .andExpect(status().isOk())
                    .andExpect(content().json(json));
    }
}