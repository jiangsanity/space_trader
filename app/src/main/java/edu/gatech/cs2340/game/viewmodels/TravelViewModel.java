package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;

import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.PlayerInteractor;

public class TravelViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    /**
     * constructor for new travel view model
     * @param application currently running app
     */
    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    /**
     * generate all available flypoints from current position
     * @return list of SS to fly to
     */
    public List<SolarSystem> getAvailableFlyPoints() {
        return interactor.getAvailableFlyPoints();
    }

    /**
     * change position of ship
     * @param s new solar system
     */
    public void fly(SolarSystem s) {
        interactor.fly(s);
    }

}
