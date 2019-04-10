package edu.gatech.cs2340.game.entity;

public class Planet {
    private final String name;

    /**
     * constructor for creating a planet
     * @param name name of planet
     */
    public Planet(String name) {
        this.name = name;
    }

    /**
     * gets name of planet
     * @return name of planet
     */
    public String getName() { return name;}

    /**
     * string representation of planet
     * @return name of planet
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * check if equal to another planet
     * @param other other planet
     * @return if two planets are equal
     */
    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(!(other instanceof Planet)) return false;
        Planet pother = (Planet)other;
        return name.equals(pother.name);
    }

    /**
     * hashcode function
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
