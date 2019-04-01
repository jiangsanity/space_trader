package edu.gatech.cs2340.game.entity;

import java.util.Random;

public abstract class RandomEvent {
    private int probability;
    private String message;

    public RandomEvent(int probability, String message) {
        this.probability = probability;
        this.message = message;
    }

    public boolean roll() {
        Random rand = new Random();
        int rollInt = rand.nextInt(101);
        return rollInt <= probability;
    }

    public String getMessage() {
        return this.message;
    }

    abstract void doEvent();
}