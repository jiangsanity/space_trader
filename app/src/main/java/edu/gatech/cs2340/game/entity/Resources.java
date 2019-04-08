package edu.gatech.cs2340.game.entity;

import java.util.Random;

public enum Resources {
    NO_SPECIAL_RESOURCES,
    MINERAL_RICH,
    MINERAL_POOR,
    DESERT,
    LOTS_OF_WATER,
    RICH_SOIL,
    POOR_SOIL,
    RICH_FAUNA,
    LIFELESS,
    WEIRD_MUSHROOMS,
    LOTS_OF_HERBS,
    ARISTIC,
    WARLIKE;

    private static final Random rand = new Random();

    public static Resources randomResource(){
        Resources[] allResources = Resources.values();
        return allResources[rand.nextInt(allResources.length - 1)];
    }
}
