package edu.gatech.cs2340.game.entity;
import java.util.HashSet;
import java.util.Random;

public enum PlanetEvents {

    DROUGHT("Drought"),
    COLD("Cold"),
    CROPFAIL("Crop fail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACKOFWORKERS("Lack of Workers");


    private String event;
    private static PlanetEvents[] allEvents = PlanetEvents.values();
    private static Random rand = new Random();

    PlanetEvents(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public static final String randomPlanetName(){
        PlanetEvents tmp = allEvents[rand.nextInt(allEvents.length)];
        return tmp.getEvent();
    }
}
