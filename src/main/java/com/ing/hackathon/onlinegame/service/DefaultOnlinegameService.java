package com.ing.hackathon.onlinegame.service;

import com.ing.hackathon.onlinegame.model.Clan;
import com.ing.hackathon.onlinegame.model.Group;
import com.ing.hackathon.onlinegame.model.Players;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultOnlinegameService implements OnlinegameService{

    //This implements First Fit Decreasing
    @Override
    public List<Group> doCalculation(Players players) {
        List<Clan> clans = new ArrayList<>(players.clans());
        clans.sort(Clan::compareTo);

        List<Group> groups = new ArrayList<>();
        for (Clan clan : clans) {
            boolean added = false;
            // Try to add clan to an existing group
            for (Group group : groups) {
                int totalPlayersInGroup = group.clans().stream().mapToInt(Clan::numberOfPlayers).sum();
                if (totalPlayersInGroup + clan.numberOfPlayers() <= players.groupCount()) {
                    group.clans().add(clan);
                    added = true;
                    break;
                }
            }
            // If clan can't be added to an existing group, create a new group
            if (!added) {
                Group group = new Group(new ArrayList<>());
                group.clans().add(clan);
                groups.add(group);
            }
        }

        return groups;
    }
}
