package edu.gatech.cs2340.game.entity;

import java.util.Random;

public enum Resources {
    NO_SPECIAL_RESOURCES(0),
    MINERAL_RICH(1),
    MINERAL_POOR(2),
    DESERT(3),
    LOTS_OF_WATER(4),
    RICH_SOIL(5),
    POOR_SOIL(6),
    RICH_FAUNA(7),
    LIFELESS(8),
    WEIRD_MUSHROOMS(9),
    LOTS_OF_HERBS(10),
    ARISTIC(11),
    WARLIKE(12);

    private final int descriptionID;
    private static final Random rand = new Random();


    Resources(int id){
        this.descriptionID = id;
    }

    public int getDescriptionID() {
        return descriptionID;
    }

    public static Resources randomResource(){
        Resources[] allResources = Resources.values();
        return allResources[rand.nextInt(allResources.length - 1)];
    }
}
