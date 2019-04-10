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

    /**
     * enum constructor for planet event
     * @param event name of event
     */
    PlanetEvents(String event) {
        this.event = event;
    }

    /**
     * gets the event associated with enum
     * @return string of event name
     */
    public String getEvent() {
        return event;
    }

    /**
     * generate random planet event
     * @return random planet event
     */
    public static final String randomPlanetEvent(){
        PlanetEvents tmp = allEvents[rand.nextInt(allEvents.length)];
        return tmp.getEvent();
    }
}
