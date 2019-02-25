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

        SolarSystem fernaduh = new SolarSystem("Fernanduh", TechLevels.HI_TECH, Resources.LIFELESS, 5134, 2666);
        fernaduh.generateRandPlanets(5);

        SolarSystem jamandus = new SolarSystem("Jamandus", TechLevels.MEDIEVAL, Resources.WARLIKE, 11234, 51552);
        jamandus.generateRandPlanets(7);

        SolarSystem travesty = new SolarSystem("Travesty", TechLevels.RENAISSANCE, Resources.WEIRD_MUSHROOMS, 140, 4432);
        travesty.generateRandPlanets(3);

        SolarSystem andromajake = new SolarSystem("Andromajake", TechLevels.POST_INDUSTRIAL, Resources.MINERAL_RICH, 56123, 9984);
        andromajake.generateRandPlanets(6);

        SolarSystem lesnia = new SolarSystem("Lesnia", TechLevels.PRE_AGRICULTURE, Resources.POOR_SOIL, 91234 , 1235);
        lesnia.generateRandPlanets(4);

        systems.add(fernaduh);
        systems.add(jamandus);
        systems.add(travesty);
        systems.add(andromajake);
        systems.add(lesnia);

        Universe.addSolarSystem(systems);

        int randSSNum = 10;
        int maxNumPlanets = 5;
        for(int i = 0; i < randSSNum; i++) {
            Universe.generateNewSS(PlanetNames.randomPlanetName(), maxNumPlanets);
        }
    }

    public Universe getUniverse() {
        return universe;
    }

    public static void main(String[] args) {
        Model m = new Model();
        m.initializeUniverse();
        System.out.println(m.getUniverse());
    }
}
