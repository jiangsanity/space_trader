package edu.gatech.cs2340.game.models;

public abstract class Interactor {
    private Repository myRepository;

    protected Interactor(Repository repo) {
        myRepository = repo;
    }

    protected Repository getRepository() {
        return myRepository;
    }
}
