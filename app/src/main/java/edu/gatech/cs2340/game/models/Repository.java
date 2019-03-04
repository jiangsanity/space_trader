package edu.gatech.cs2340.game.models;


import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.game.entity.Planet;
import edu.gatech.cs2340.game.entity.PlanetNames;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Resources;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.TechLevels;
import edu.gatech.cs2340.game.entity.Universe;

public class Repository {
    private Universe universe;
    private Player player;


    public Repository() {
        universe = Universe.getInstance();
        player = new Player();
        //initializeUniverse();
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

    public Player getPlayer() {
        return player;
    }

    public void addSolarSystem(SolarSystem s) {
        Universe.addSolarSystem(s);
    }

    public void addPlanetToSS(Planet p, SolarSystem s) {
        Universe.addPlanet(p, s);
    }

    public void removeSolarSystem(String systemName) {
        Universe.removeSolarSystem(systemName);
    }

    public void removePlanetFromSS(String planetName, String ssName) {
        Universe.removePlanet(planetName, ssName);
    }

    public void updatePlayer(Player p) {
        player.setDifficulty(p.getDifficulty());
        player.setEngineerPoints(p.getEngineerPoints());
        player.setFighterPoints(p.getFighterPoints());
        player.setName(p.getName());
        player.setPilotPoints(p.getPilotPoints());
        player.setTraderPoints(p.getTraderPoints());
        player.setShip(p.getShip());
    }

    public void addNewShip(Ship s) {
        player.setShip(s);
    }

    public SolarSystem getRandomSS() {
        return Universe.getSystems().iterator().next();
    }

    public void playerBuy(String item, int n) {
        player.buy(item, n);
    }

    public void playerSell(String item, int n) {
        player.sell(item, n);
    }
}
