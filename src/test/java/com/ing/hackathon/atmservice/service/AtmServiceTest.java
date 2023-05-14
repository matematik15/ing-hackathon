package com.ing.hackathon.atmservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.hackathon.atmservice.model.Task;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class AtmServiceTest {


    AtmService transactionService = new DefaultAtmService();

    @Test
    public void testOrderGenerationProcessingTime() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/atms.json");
        List<Task> tasks = objectMapper.readValue(inputStream, new TypeReference<>() {
        });

        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            transactionService.doCalculation(tasks);
        }
        long endTime = System.nanoTime();

        long elapsedTime = endTime - startTime;
        System.out.println("Processing time: " + elapsedTime + " nanoseconds");
    }
}
