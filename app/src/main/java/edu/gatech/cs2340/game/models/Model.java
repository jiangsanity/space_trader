package edu.gatech.cs2340.game.models;

import edu.gatech.cs2340.game.entity.Planet;
import edu.gatech.cs2340.game.entity.PlanetNames;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Resources;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.TechLevels;
import edu.gatech.cs2340.game.entity.Universe;

import java.util.List;
import java.util.ArrayList;

public class Model {

    private Player p;
    private Universe universe;

    private static Model instance = new Model();

    private Model() {
        p = new Player();
        universe = Universe.getInstance();
    }

    public static Model getInstance() {
        return instance;
    }

    public void initializeUniverse() {
        List<SolarSystem> systems = new ArrayList<>();
        SolarSystem milkyWay = new SolarSystem("Milky Way", TechLevels.HI_TECH, Resources.LOTS_OF_WATER, 3412, 231);
        milkyWay.addPlanet(new Planet("Mercury"));
        milkyWay.addPlanet(new Planet("Venus"));
        milkyWay.addPlanet(new Planet("Earth"));
        milkyWay.addPlanet(new Planet("Mars"));
        systems.add(milkyWay);

        SolarSystem fernaduh = new SolarSystem("Fernanduh", TechLevels.HI_TECH, Resources.LIFELESS, 5134, 2666);
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        fernaduh.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        systems.add(fernaduh);

        SolarSystem jamandus = new SolarSystem("Jamandus", TechLevels.MEDIEVAL, Resources.WARLIKE, 11234, 51552);
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        jamandus.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        systems.add(jamandus);

        SolarSystem travesty = new SolarSystem("Travesty", TechLevels.RENAISSANCE, Resources.WEIRD_MUSHROOMS, 140, 4432);
        travesty.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        travesty.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        travesty.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        systems.add(travesty);

        SolarSystem andromajake = new SolarSystem("Andromajake", TechLevels.POST_INDUSTRIAL, Resources.MINERAL_RICH, 56123, 9984);
        andromajake.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        andromajake.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        andromajake.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        andromajake.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        andromajake.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        andromajake.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        systems.add(andromajake);

        SolarSystem lesnia = new SolarSystem("Lesnia", TechLevels.PRE_AGRICULTURE, Resources.POOR_SOIL, 91234 , 1235);
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        lesnia.addPlanet(new Planet(PlanetNames.randomPlanetName()));
        systems.add(lesnia);

        universe.addSolarSystem(systems);
    }

    public Universe getUniverse() {
        return universe;
    }
}
