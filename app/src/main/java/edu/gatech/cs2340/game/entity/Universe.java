package edu.gatech.cs2340.game.entity;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

//treat as singleton
public class Universe {
    private static Map<String, SolarSystem> systems;

    private static final Universe instance = new Universe();
    private static HashSet<Point2D> solarSystemPoints;

    /**
     * No args constructor that initializes the solar system universe and
     * set to ensure no 2 solar systems are in the same place
     */
    private Universe() {
        systems = new HashMap<>();
        solarSystemPoints = new HashSet<>();
    }

    /**
     * singleton getter
     * @return universe instance
     */
    public static Universe getInstance() {
        return instance;
    }

    /**
     * adds a solar system to the universe
     * @param newSystem the solar system to be added
     */
    private static void addSolarSystem(SolarSystem newSystem) {
        if(!systems.containsKey(newSystem.getName())){
            systems.put(newSystem.getName(), newSystem);
        }
    }

    /**
     * generates a new solar system with a specified name and number of planets
     * @param name name of new solar system
     * @param numPlanets number planets wanted
     */
    public static void generateNewSS(String name, int numPlanets) {
        Random rand = new Random();
        int maxRange = 10000000;
        Point2D newLoc = new Point2D(rand.nextInt(maxRange), rand.nextInt(maxRange));
        while(solarSystemPoints.contains(newLoc)) {
            newLoc = new Point2D(rand.nextInt(maxRange), rand.nextInt(maxRange));
        }
        solarSystemPoints.add(newLoc);
        SolarSystem newSS = new SolarSystem(name, TechLevels.randomTechLevel(), Resources.randomResource(), newLoc.getX(), newLoc.getY());

        for(int i = 0; i < rand.nextInt(numPlanets) + 1; i++) {
            newSS.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        }

        addSolarSystem(newSS);
    }

    /**
     * gets all the solar systems in this universe
     * @return collection of solar systems in the universe
     */
    public static Collection<SolarSystem> getSystems() {
        return systems.values();
    }

    /**
     * gets entire mapping of solar systems
     * @return map of solar system
     */
    static Map<String, SolarSystem> getSystemsMap() {
        return systems;
    }

    /**
     * string represenation of a universe
     * @return string representing universe
     */
    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("Universe contains Solar Systems:\n");
        for(SolarSystem s : systems.values()) {
            ret.append(s.toString()).append("\n");
        }
        return ret.toString();
    }

    /**
     * used for saving
     * @param prefs prefs for saving
     */
    public void saveUniverse(SharedPreferences prefs) {
        saveHashMap(systems, prefs);
    }

    /**
     * used for restoring
     * @param prefs prefs for restoring
     */
    public void restoreUniverse(SharedPreferences prefs) {
        systems = restoreHashMap(prefs);
    }

    /**
     * used for saving
     * @param obj object to save
     * @param prefs prefs for saving
     */
    //credit: https://freakycoder.com/android-notes-41-how-to-save-and-get-hashmap-into-sharedpreference-e686ead94b6c
    private void saveHashMap(Object obj, SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        editor.putString("systems",json);
        editor.apply();
    }

    /**
     * used for restoring univserse
     * @param prefs prefs for restoring
     * @return gson for restorations
     */
    //credit: https://freakycoder.com/android-notes-41-how-to-save-and-get-hashmap-into-sharedpreference-e686ead94b6c
    private static HashMap<String, SolarSystem> restoreHashMap(SharedPreferences prefs) {
        Gson gson = new Gson();
        String json = prefs.getString("systems","");
        java.lang.reflect.Type type = new TypeToken<HashMap<String, SolarSystem>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
