package edu.gatech.cs2340.game.models;

import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Ship;

public class PlayerInteractor extends Interactor {
    public PlayerInteractor(Repository repo) {super(repo);}

    public Player getPlayer() { return getRepository().getPlayer(); };

    public void updatePlayer(Player p) {
        getRepository().updatePlayer(p);
    }

    public void addNewShip(Ship s) {
        getRepository().addNewShip(s);
    }

}
