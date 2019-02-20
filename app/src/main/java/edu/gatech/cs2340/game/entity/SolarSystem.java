package edu.gatech.cs2340.game.entity;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    private List<Planet> planets;
    private String name;

    public SolarSystem(String name) {
        this.name = name;
        this.planets = new ArrayList<>();
    }

    private boolean addPlanet(Planet p) {
        if(planets.contains(p)) {
            return false;
        } else {
            planets.add(p);
            return true;
        }
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public String getName() {
        return name;
    }
}
