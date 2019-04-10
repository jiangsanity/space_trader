package edu.gatech.cs2340.game.entity;

import java.util.Random;

public abstract class RandomEvent {
    private final int probability;
    private final String message;

    /**
     * abstract constructor for random event
     * @param probability probabilty of event happening
     * @param message message associated with event
     */
    RandomEvent(int probability, String message) {
        this.probability = probability;
        this.message = message;
    }

    /**
     * roll to see if event occurs
     * @return true or false if event occured
     */
    public boolean roll() {
        Random rand = new Random();
        int rollInt = rand.nextInt(101);
        return rollInt <= probability;
    }

    /**
     * gets message of event
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

}
