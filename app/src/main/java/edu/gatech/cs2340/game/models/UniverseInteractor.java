package edu.gatech.cs2340.game.models;

import android.content.SharedPreferences;

import edu.gatech.cs2340.game.entity.SolarSystem;
import edu.gatech.cs2340.game.entity.Universe;

public class UniverseInteractor extends Interactor {

    public UniverseInteractor(Repository repo) {super(repo);}

    public Universe getUniverse() { return getRepository().getUniverse(); }

    public void initializeUniverse() { getRepository().initializeUniverse(); }

    public void initializeUniverse(SharedPreferences prefs) {
        getRepository().initializeUniverse(prefs);
    }

    public SolarSystem getRandomSS() {
        return getRepository().getRandomSS();
    }
}
