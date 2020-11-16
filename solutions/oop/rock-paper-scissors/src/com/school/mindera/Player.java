package com.school.mindera;

public class Player {

    private int wins;
    private String name;

    public Player(String name) {
        this.wins = 0;
        this.name = name;
    }

    public int getWins() {
        return this.wins;
    }

    public String getName() {
        return this.name;
    }

    public void addWin() {
        wins++;
    }

    public GameHand chooseHand() {
        int random = (int) (Math.random() * GameHand.values().length);
        return GameHand.values()[random];
    }
}
