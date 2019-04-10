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

    /**
     * Repository constructor
     */
    Repository() {
        universe = Universe.getInstance();
        player = new Player();
        //initializeUniverse();
    }

    /**
     * initializes the universe with random solar systems
     */
    void initializeUniverse() {
        int randSSNum = 10;
        int maxNumPlanets = 5;
        for(int i = 0; i < randSSNum; i++) {
            Universe.generateNewSS(PlanetNames.randomPlanetName(), maxNumPlanets);
        }
    }

    /**
     * initializes universe for restoring state of game
     * @param prefs shared prefs to use
     */
    void initializeUniverse(SharedPreferences prefs) {
        universe.restoreUniverse(prefs);
    }

    /**
     * getter for universe in repo
     * @return universe
     */
    Universe getUniverse() {
        return universe;
    }

    /**
     * getter for player in repo
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * updates current player if any changes occur
     * @param p player to update to
     */
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

    /**
     * gives player new ship
     * @param s ship to reassign
     */
    void addNewShip(Ship s) {
        player.setShip(s);
    }

    /**
     * gets random solar system from universe
     * @return solar system
     */
    SolarSystem getRandomSS() {
        return Universe.getSystems().iterator().next();
    }

    /**
     * buy an item from marketplace
     * @param item item to buy
     * @param n quantity
     */
    void playerBuy(String item, int n) {
        player.buy(item, n);
    }

    /**
     * sell an item to marketplace
     * @param item item to sell
     * @param n quantity
     */
    void playerSell(String item, int n) {
        player.sell(item, n);
    }

    /**
     * generate all available flypoints from current position
     * @return list of SS to fly to
     */
    List<SolarSystem> getAvailableFlyPoints() {
        return player.getAvailableFlyPoints();
    }

    /**
     * change position of ship
     * @param s new solar system
     */
    void fly(SolarSystem s) {
        player.fly(s);
    }

    /**
     * refuels ship when out of fuel
     */
    void refuel() {
        player.refuel();
    }

}

