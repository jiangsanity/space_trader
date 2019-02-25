package edu.gatech.cs2340.game.entity;

import java.util.Random;

public enum TechLevels {
    PRE_AGRICULTURE(0),
    AGRICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EARLY_INDUSTRY(4),
    INDUSTRY(5),
    POST_INDUSTRIAL(6),
    HI_TECH(7);

    private int descriptionID;
    private static Random rand = new Random();

    private TechLevels(int id){
        this.descriptionID = id;
    }

    public int getDescriptionID() {
        return descriptionID;
    }

    public static final TechLevels randomTechLevel(){
        TechLevels[] allLevels = TechLevels.values();
        return allLevels[rand.nextInt(allLevels.length)];
    }
}
