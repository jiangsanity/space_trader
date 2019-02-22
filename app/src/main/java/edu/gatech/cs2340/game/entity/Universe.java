package edu.gatech.cs2340.game.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

    @Override
    public String toString() {
        String ret = "Universe contains Solar Systems:\n";
        for(SolarSystem s : systems.values()) {
            ret += s.toString() + "\n";
        }
        return ret;
    }
}
