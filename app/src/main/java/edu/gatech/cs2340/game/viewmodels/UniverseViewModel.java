package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.Universe;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.UniverseInteractor;

public class UniverseViewModel extends AndroidViewModel {

    private UniverseInteractor interactor;

    public UniverseViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getUniverseInteractor();
    }

    public void initializeUniverse() { interactor.initializeUniverse(); }

    public Universe getUniverse() { return interactor.getUniverse(); }

    public SolarSystem getRandomSS() {
        return interactor.getRandomSS();
    }
}
