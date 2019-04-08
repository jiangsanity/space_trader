package edu.gatech.cs2340.game.models;


import android.content.SharedPreferences;

import java.util.List;

import edu.gatech.cs2340.game.entity.PlanetNames;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.Universe;

class Repository {
    private final Universe universe;
    private final Player player;


    Repository() {
        universe = Universe.getInstance();
        player = new Player();
        //initializeUniverse();
    }

    void initializeUniverse() {
        int randSSNum = 10;
        int maxNumPlanets = 5;
        for(int i = 0; i < randSSNum; i++) {
            Universe.generateNewSS(PlanetNames.randomPlanetName(), maxNumPlanets);
        }
    }

    void initializeUniverse(SharedPreferences prefs) {
        universe.restoreUniverse(prefs);
    }

    Universe getUniverse() {
        return universe;
    }

    public Player getPlayer() {
        return player;
    }

    void updatePlayer(Player p) {
        player.setDifficulty(p.getDifficulty());
        player.setEngineerPoints(p.getEngineerPoints());
        player.setFighterPoints(p.getFighterPoints());
        player.setName(p.getName());
        player.setPilotPoints(p.getPilotPoints());
        player.setTraderPoints(p.getTraderPoints());
        player.setBalance(p.getBalance());
        player.setShip(p.getShip());
    }

    void addNewShip(Ship s) {
        player.setShip(s);
    }

    SolarSystem getRandomSS() {
        return Universe.getSystems().iterator().next();
    }

    void playerBuy(String item, int n) {
        player.buy(item, n);
    }

    void playerSell(String item, int n) {
        player.sell(item, n);
    }

    List<SolarSystem> getAvailableFlyPoints() {
        return player.getAvailableFlyPoints();
    }

    void fly(SolarSystem s) {
        player.fly(s);
    }

    void refuel() {
        player.refuel();
    }

}

