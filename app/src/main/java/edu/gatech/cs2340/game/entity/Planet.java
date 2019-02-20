package edu.gatech.cs2340.game.entity;

public class Planet {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if(other == null) return false;
        if(!(other instanceof Planet)) return false;
        Planet pother = (Planet)other;
        return name.equals(pother.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}