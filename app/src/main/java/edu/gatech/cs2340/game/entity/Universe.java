package edu.gatech.cs2340.game.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;

//treat as singleton
public class Universe {
    private static Map<String, SolarSystem> systems;

    private static Universe instance = new Universe();

    private Universe() {
        this.systems = new HashMap<>();
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
        Point2D newLoc = new Point2D(rand.nextInt(Integer.MAX_VALUE), rand.nextInt(Integer.MAX_VALUE));
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

    @Override
    public String toString() {
        String ret = "Universe contains Solar Systems:\n";
        for(SolarSystem s : systems.values()) {
            ret += s.toString() + "\n";
        }
        return ret;
    }
}
