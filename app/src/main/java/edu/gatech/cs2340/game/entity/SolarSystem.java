package edu.gatech.cs2340.game.entity;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    private List<Planet> planets;
    private String name;
    private Point2D pos;
    private TechLevels techLevel;
    private Resources resources;
	private Marketplace marketplace;

    public SolarSystem(String name, TechLevels techLevel, Resources resources, int x, int y) {
        this.name = name;
        this.techLevel = techLevel;
        this.resources = resources;
        this.planets = new ArrayList<>();
        this.pos = new Point2D(x, y);
		marketplace = new Marketplace(this.techLevel);
    }

    public SolarSystem(String name) {
        this(name, TechLevels.PRE_AGRICULTURE, Resources.NO_SPECIAL_RESOURCES, 0, 0);
    }

    public boolean addPlanet(Planet p) {
        if(planets.contains(p)) {
            return false;
        } else {
            planets.add(p);
            return true;
        }
    }

    public void removePlanet(String s) {
        for(int i = 0; i < planets.size(); i++) {
            if(planets.get(i).getName().equals(s)) {
                planets.remove(i);
                return;
            }
        }
    }

    public void generateRandPlanets(int numPlanets) {
        for(int i = 0; i < numPlanets; i++) {
            this.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        }
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public TechLevels getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(TechLevels techLevel) {
        this.techLevel = techLevel;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    @Override
    public String toString() {
        return name + "@" + pos.toString() +" : " + planets.toString();
    }
}
