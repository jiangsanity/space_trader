package edu.gatech.cs2340.game.models;

import java.util.List;

import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.entity.SolarSystem;

public class PlayerInteractor extends Interactor {
    /**
     * constructor for player interactor
     * @param repo repo to instantiate with
     */
    public PlayerInteractor(Repository repo) {super(repo);}

    /**
     * getter for player in repo
     * @return player
     */
    public Player getPlayer() { return getRepository().getPlayer(); }

    /**
     * updates current player if any changes occur
     * @param p player to update to
     */
    public void updatePlayer(Player p) {
        getRepository().updatePlayer(p);
    }

    /**
     * gives player new ship
     * @param s ship to reassign
     */
    public void addNewShip(Ship s) {
        getRepository().addNewShip(s);
    }

    /**
     * buy an item from marketplace
     * @param item item to buy
     * @param n quantity
     */
    public void buy(String item, int n) {
        getRepository().playerBuy(item, n);
    }

    /**
     * sell an item to marketplace
     * @param item item to sell
     * @param n quantity
     */
    public void sell(String item, int n) {
        getRepository().playerSell(item, n);
    }

    /**
     * generate all available flypoints from current position
     * @return list of SS to fly to
     */
    public List<SolarSystem> getAvailableFlyPoints() {
        return getRepository().getAvailableFlyPoints();
    }

    /**
     * change position of ship
     * @param s new solar system
     */
    public void fly(SolarSystem s) {
        getRepository().fly(s);
    }

}
