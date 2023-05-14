package com.ing.hackathon.onlinegame.controller;

import com.ing.hackathon.onlinegame.model.Clan;
import com.ing.hackathon.onlinegame.model.Group;
import com.ing.hackathon.onlinegame.model.Players;
import com.ing.hackathon.onlinegame.service.OnlinegameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/onlinegame")
public class OnlineGameController {

    @Autowired
    private OnlinegameService onlinegameService;

    @PostMapping("/calculate")
    public ResponseEntity<List<List<Clan>>> calculate(@RequestBody Players players) {
        List<Group> groups = onlinegameService.doCalculation(players);
        List<List<Clan>> clans = groups.stream().map(Group::clans).collect(Collectors.toList());
        return ResponseEntity.ok(clans);
    }
}