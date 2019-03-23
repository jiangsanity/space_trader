package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.SortedMap;

import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.PlayerInteractor;

public class TravelViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    public TravelViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getPlayerInteractor();
    }

    public List<SolarSystem> getAvailableFlyPoints() {
        return interactor.getAvailableFlyPoints();
    }

    public void fly(SolarSystem s) {
        interactor.fly(s);
    }

    public void refuel() {
        interactor.refuel();
    }
}
