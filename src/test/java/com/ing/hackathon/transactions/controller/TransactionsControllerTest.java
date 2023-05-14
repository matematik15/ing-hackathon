package com.ing.hackathon.transactions.controller;

import static com.ing.hackathon.util.Helper.readJsonFromFile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateOrderProcessingTime() throws Exception {

        String tasksJson = readJsonFromFile("transactions.json");

        long startTime = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            mockMvc.perform(post("/transactions/report")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(tasksJson))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.accounts").isNotEmpty())
                    //.andDo(print())
            ;
        }
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        System.out.println("Processing time: " + elapsedTime + " nanoseconds");
    }
}
