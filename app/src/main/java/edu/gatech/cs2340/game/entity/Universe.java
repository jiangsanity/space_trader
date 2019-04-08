package edu.gatech.cs2340.game.entity;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Random;

//treat as singleton
public class Universe {
    private static Map<String, SolarSystem> systems;

    private static final Universe instance = new Universe();
    private static HashSet<Point2D> solarSystemPoints;

    private Universe() {
        systems = new HashMap<>();
        solarSystemPoints = new HashSet<>();
    }

    public static Universe getInstance() {
        return instance;
    }

    public static boolean addSolarSystem(SolarSystem newSystem) {
        if(systems.containsKey(newSystem.getName())){
            return false;
        } else {
            systems.put(newSystem.getName(), newSystem);
            return true;
        }
    }

    public static void addSolarSystem(List<SolarSystem> newSystemList) {
        for(SolarSystem system : newSystemList) {
            addSolarSystem(system);
        }
    }

    public static void removeSolarSystem(String ssName) {
        systems.remove(ssName);
    }

    public static void removePlanet(String ssName, String pName) {
        SolarSystem tempS = systems.get(ssName);
        tempS.removePlanet(pName);
        systems.put(ssName, tempS);
    }

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

    public static void addPlanet(Planet p, SolarSystem s) {
        SolarSystem tempS = systems.get(s.getName());
        tempS.addPlanet(p);
        systems.put(s.getName(), tempS);
    }

    public static Collection<SolarSystem> getSystems() {
        return systems.values();
    }

    public static Map<String, SolarSystem> getSystemsMap() {
        return systems;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("Universe contains Solar Systems:\n");
        for(SolarSystem s : systems.values()) {
            ret.append(s.toString()).append("\n");
        }
        return ret.toString();
    }

    public void saveUniverse(SharedPreferences prefs) {
        saveHashMap("systems", systems, prefs);
    }

    public void restoreUniverse(SharedPreferences prefs) {
        systems = restoreHashMap("systems", prefs);
    }

    //credit: https://freakycoder.com/android-notes-41-how-to-save-and-get-hashmap-into-sharedpreference-e686ead94b6c
    private void saveHashMap(String key, Object obj, SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        editor.putString(key,json);
        editor.apply();
    }

    //credit: https://freakycoder.com/android-notes-41-how-to-save-and-get-hashmap-into-sharedpreference-e686ead94b6c
    private static HashMap<String, SolarSystem> restoreHashMap(String key, SharedPreferences prefs) {
        Gson gson = new Gson();
        String json = prefs.getString(key,"");
        java.lang.reflect.Type type = new TypeToken<HashMap<String, SolarSystem>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
