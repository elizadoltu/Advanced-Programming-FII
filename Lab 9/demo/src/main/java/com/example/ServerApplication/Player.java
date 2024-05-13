package com.example.ServerApplication;

public class Player {

    private String playerId;
    private String username;
    private int remainingTime;

    public Player(String playerId, String username, int remainingTime) {
        this.playerId = playerId;
        this.username = username;
        this.remainingTime = remainingTime;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }
}
