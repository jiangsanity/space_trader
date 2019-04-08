package edu.gatech.cs2340.game.models;

abstract class Interactor {
    private final Repository myRepository;

    Interactor(Repository repo) {
        myRepository = repo;
    }

    Repository getRepository() {
        return myRepository;
    }
}
