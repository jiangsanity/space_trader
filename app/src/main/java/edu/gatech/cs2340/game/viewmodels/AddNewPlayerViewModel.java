package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.PlayerInteractor;

public class AddNewPlayerViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;
    private Player currentPlayer;

    public AddNewPlayerViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    public void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }


}
