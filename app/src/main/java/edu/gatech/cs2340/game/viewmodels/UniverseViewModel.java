package edu.gatech.cs2340.game.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.Universe;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.UniverseInteractor;

public class UniverseViewModel extends AndroidViewModel {

    private final UniverseInteractor interactor;

    /**
     * constructor for new universe view model
     * @param application currently running application
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getUniverseInteractor();
    }

    /**
     * initializes the universe with random solar systems
     */
    public void initializeUniverse() { interactor.initializeUniverse(); }

    /**
     * initializes universe for restoring state of game
     * @param prefs shared prefs to use
     */
    public void initializeUniverse(SharedPreferences prefs) {
        interactor.initializeUniverse(prefs);
    }

    /**
     * getter for universe in repo
     * @return universe
     */
    public Universe getUniverse() { return interactor.getUniverse(); }

    /**
     * gets random solar system from universe
     * @return solar system
     */
    public SolarSystem getRandomSS() {
        return interactor.getRandomSS();
    }
}
