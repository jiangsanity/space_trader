package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.PlayerInteractor;

public class AddNewPlayerViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    /**
     * constructor for new player view model
     * @param application currently running app
     */
    public AddNewPlayerViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    /**
     * updates current player if any changes occur
     * @param p player to update to
     */
    public void setCurrentPlayer(Player p) {
        interactor.updatePlayer(p);
    }

    /**
     * gives player new ship
     * @param s ship to reassign
     */
    public void setCurrentShip(Ship s) {
        interactor.addNewShip(s);
    }


}
