package edu.gatech.cs2340.game.entity;

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

    private int descriptionID;

    private Resources(int id){
        this.descriptionID = id;
    }

    public int getDescriptionID() {
        return descriptionID;
    }
}
