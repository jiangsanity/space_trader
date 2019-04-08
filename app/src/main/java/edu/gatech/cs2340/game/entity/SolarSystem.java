package edu.gatech.cs2340.game.entity;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    private final List<Planet> planets;
    private final String name;
    private final Point2D pos;
    private final TechLevels techLevel;
    private final Resources resources;
	private final Marketplace marketplace;

    public SolarSystem(String name, TechLevels techLevel, Resources resources, int x, int y) {
        this.name = name;
        this.techLevel = techLevel;
        this.resources = resources;
        this.planets = new ArrayList<>();
        this.pos = new Point2D(x, y);
		marketplace = new Marketplace(this.techLevel);
    }

    public void addPlanet(Planet p) {
        if(!planets.contains(p)) {
            planets.add(p);
        }
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void removePlanet(Planet p) {
        if (planets.contains(p)) {
            planets.remove(p);
        }
    }

    public String getName() {
        return name;
    }

    public Point2D getPos() {
        return pos;
    }

    public TechLevels getTechLevel() {
        return techLevel;
    }

    public Resources getResources() {
        return resources;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    @Override
    public String toString() {
        return name + " TL:" + techLevel + ", RS:" + resources + " @ " + pos.toString() +" : " + planets.toString();
    }
}
