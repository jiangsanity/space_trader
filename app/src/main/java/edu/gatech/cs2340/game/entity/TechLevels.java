package edu.gatech.cs2340.game.entity;

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

    private TechLevels(int id){
        this.descriptionID = id;
    }

    public int getDescriptionID() {
        return descriptionID;
    }
}
