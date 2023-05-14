package com.ing.hackathon.atmservice.service;

import com.ing.hackathon.atmservice.model.ATM;
import com.ing.hackathon.atmservice.model.Task;

import java.util.List;

public interface AtmService {
    List<ATM> doCalculation(List<Task> tasks);
}
