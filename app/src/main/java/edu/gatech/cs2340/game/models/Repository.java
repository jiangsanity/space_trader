package edu.gatech.cs2340.game.models;


import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.game.entity.Planet;
import edu.gatech.cs2340.game.entity.PlanetNames;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Point2D;
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
        int randSSNum = 10;
        int maxNumPlanets = 5;
        for(int i = 0; i < randSSNum; i++) {
            Universe.generateNewSS(PlanetNames.randomPlanetName(), maxNumPlanets);
        }
    }

    public void initializeUniverse(SharedPreferences prefs) {
        universe.restoreUniverse(prefs);
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
        player.setBalance(p.getBalance());
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

    public List<SolarSystem> getAvailableFlyPoints() {
        return player.getAvailableFlyPoints();
    }

    public void fly(SolarSystem s) {
        player.fly(s);
    }

    public int getFlyCost(SolarSystem s) {
        return player.getFlyCost(s);
    }

    public void refuel() {
        player.refuel();
    }

    public int getFuelCellLevel() {
        return player.getFuelCellLevel();
    }
}

