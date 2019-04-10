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

    private final int descriptionID;
    private static final Random rand = new Random();

    /**
     * enum constructor corresponding tech level to description
     * @param id number
     */
    TechLevels(int id){
        this.descriptionID = id;
    }

    /**
     * id getter
     * @return id
     */
    public int getDescriptionID() {
        return descriptionID;
    }

    /**
     * generate random tech level
     * @return tech level
     */
    public static TechLevels randomTechLevel(){
        TechLevels[] allLevels = TechLevels.values();
        return allLevels[rand.nextInt(allLevels.length)];
    }
}
