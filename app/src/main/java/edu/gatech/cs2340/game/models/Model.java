package edu.gatech.cs2340.game.models;

import edu.gatech.cs2340.game.entity.Planet;
import edu.gatech.cs2340.game.entity.PlanetNames;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Resources;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.TechLevels;
import edu.gatech.cs2340.game.entity.Universe;

public class Model {

    private Player p;
    private Universe universe;

    private static Model instance = new Model();

    private Model() {
        p = new Player();
        universe = Universe.getInstance();
    }

    public void initializeUniverse() {
        SolarSystem milkyWay = new SolarSystem("Milky Way");
        milkyWay.addPlanet(new Planet("Mercury"));
        milkyWay.addPlanet(new Planet("Venus"));
        milkyWay.addPlanet(new Planet("Earth"));
        milkyWay.addPlanet(new Planet("Mars"));

        SolarSystem fernaduh = new SolarSystem("Fernanduh", TechLevels.HI_TECH, Resources.LIFELESS, 5134, 2666);
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));

        System.out.println(milkyWay);
        System.out.println(fernaduh);
    }

    public static void main(String[] args) {
        Model m = new Model();
        m.initializeUniverse();
    }
}
