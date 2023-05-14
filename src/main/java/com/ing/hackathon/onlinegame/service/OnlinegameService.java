package com.ing.hackathon.onlinegame.service;

import com.ing.hackathon.onlinegame.model.Group;
import com.ing.hackathon.onlinegame.model.Players;

import java.util.List;

public interface OnlinegameService {
    public List<Group> doCalculation(Players players);
}
