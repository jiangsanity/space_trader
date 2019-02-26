package edu.gatech.cs2340.game.models;

import edu.gatech.cs2340.game.entity.Universe;

public class UniverseInteractor extends Interactor {

    public UniverseInteractor(Repository repo) {super(repo);}

    public Universe getUniverse() { return getRepository().getUniverse(); };

}
