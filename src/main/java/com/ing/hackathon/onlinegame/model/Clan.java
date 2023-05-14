package com.ing.hackathon.onlinegame.model;

public record Clan(int numberOfPlayers, int points) implements Comparable<Clan> {

    // Clan with more points is stronger. When points are equal, the clan with smaller number of players is stronger.
    @Override
    public int compareTo(Clan other) {
        if(points == other.points()) {
            return numberOfPlayers - other.numberOfPlayers;
        }
        return other.points - points;
    }
}