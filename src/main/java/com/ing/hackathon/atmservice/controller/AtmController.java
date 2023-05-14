package com.ing.hackathon.atmservice.controller;

import com.ing.hackathon.atmservice.model.ATM;
import com.ing.hackathon.atmservice.model.Task;
import com.ing.hackathon.atmservice.service.AtmService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atms")
public class AtmController {

  @Autowired
  private AtmService atmService;

  @PostMapping("/calculateOrder")
  public ResponseEntity<List<ATM>> calculateOrder (@RequestBody List<Task> tasks) {
    List<ATM> atms = atmService.doCalculation(tasks);
    return ResponseEntity.ok(atms);
  }
}
