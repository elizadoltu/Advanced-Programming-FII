package com.example.ServerApplication;

import java.util.ArrayList;
import java.util.List;

import com.example.ServerApplication.Player;

public class Game {
    private String gameId;
    private List<Player> players;
    private boolean isActive;
    private int timeLimit;

    public Game(String gameId, int timeLimit) {
        this.gameId = gameId;
        this.players = new ArrayList<>();
        this.isActive = false;
        this.timeLimit = timeLimit;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
