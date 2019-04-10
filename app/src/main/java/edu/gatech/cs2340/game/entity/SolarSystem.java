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

    /**
     * Constructor for solar system object
     * @param name name of solar system
     * @param techLevel tech level of solar system
     * @param resources resource level of solar system
     * @param x position of SS
     * @param y position of SS
     */
    public SolarSystem(String name, TechLevels techLevel, Resources resources, int x, int y) {
        this.name = name;
        this.techLevel = techLevel;
        this.resources = resources;
        this.planets = new ArrayList<>();
        this.pos = new Point2D(x, y);
		marketplace = new Marketplace(this.techLevel);
    }

    /**
     * adds planet to current solar system
     * @param p planet to add
     */
    public void addPlanet(Planet p) {
        if(!planets.contains(p)) {
            planets.add(p);
        }
    }

    /**
     * gets all planets in current solar system
     * @return list of planets
     */
    public List<Planet> getPlanets() {
        return planets;
    }

    /**
     * removes planet of solar system
     * @param p planet to remove
     */
    public void removePlanet(Planet p) {
        if (planets.contains(p)) {
            planets.remove(p);
        }
    }

    /**
     * name field getter
     * @return name of SS
     */
    public String getName() {
        return name;
    }

    /**
     * position getter
     * @return Point2D of position of ss
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * tech level field getter
     * @return tech level
     */
    public TechLevels getTechLevel() {
        return techLevel;
    }

    /**
     * resource level field getter
     * @return resource
     */
    public Resources getResources() {
        return resources;
    }

    /**
     * marketplace getter
     * @return marketplace
     */
    public Marketplace getMarketplace() {
        return marketplace;
    }

    /**
     * string representation of solar system
     * @return print string
     */
    @Override
    public String toString() {
        return name + " TL:" + techLevel + ", RS:" + resources + " @ " + pos.toString() +" : " + planets.toString();
    }
}
