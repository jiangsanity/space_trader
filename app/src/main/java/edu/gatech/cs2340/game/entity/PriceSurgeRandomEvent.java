package edu.gatech.cs2340.game.entity;

import java.util.Random;

public class PriceSurgeRandomEvent extends RandomEvent{
    private final Player player;

    /**
     * constructor for random event
     * @param p player of current game
     */
    public PriceSurgeRandomEvent(Player p) {
        super(40, "A shortage on supplies has caused this planet to drastically increase it's prices!");
        player = p;
    }

    /**
     * causes current marketplace to increase costs of all items
     */
    public void doEvent() {
        int hikeVal = (new Random()).nextInt(40) + 20;
        player.getShip().getCurrentSS().getMarketplace().priceHike(hikeVal);
    }
}
