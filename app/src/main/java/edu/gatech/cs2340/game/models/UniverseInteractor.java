package edu.gatech.cs2340.game.models;

import android.content.SharedPreferences;

import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.Universe;

public class UniverseInteractor extends Interactor {
    /**
     * constructor for universe interactor
     * @param repo repo to instantiate with
     */
    public UniverseInteractor(Repository repo) {super(repo);}

    /**
     * getter for universe in repo
     * @return universe
     */
    public Universe getUniverse() { return getRepository().getUniverse(); }

    /**
     * initializes the universe with random solar systems
     */
    public void initializeUniverse() { getRepository().initializeUniverse(); }

    /**
     * initializes universe for restoring state of game
     * @param prefs shared prefs to use
     */
    public void initializeUniverse(SharedPreferences prefs) {
        getRepository().initializeUniverse(prefs);
    }

    /**
     * gets random solar system from universe
     * @return solar system
     */
    public SolarSystem getRandomSS() {
        return getRepository().getRandomSS();
    }
}
