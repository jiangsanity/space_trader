package edu.gatech.cs2340.game.models;

import java.util.List;

import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Point2D;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.entity.SolarSystem;

public class PlayerInteractor extends Interactor {
    public PlayerInteractor(Repository repo) {super(repo);}

    public Player getPlayer() { return getRepository().getPlayer(); };

    public void updatePlayer(Player p) {
        getRepository().updatePlayer(p);
    }

    public void addNewShip(Ship s) {
        getRepository().addNewShip(s);
    }

    public void buy(String item, int n) {
        getRepository().playerBuy(item, n);
    }

    public void sell(String item, int n) {
        getRepository().playerSell(item, n);
    }

    public List<SolarSystem> getAvailableFlyPoints() {
        return getRepository().getAvailableFlyPoints();
    }

    public void fly(SolarSystem s) {
        getRepository().fly(s);
    }

    public void refuel() {
        getRepository().refuel();
    }

    public int getFuelCellLevel() {
        return getRepository().getFuelCellLevel();
    }

    public int getFlyCost(SolarSystem s) {
        return getRepository().getFlyCost(s);
    }
}
