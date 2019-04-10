package edu.gatech.cs2340.game.models;

abstract class Interactor {
    private final Repository myRepository;

    /**
     * interactor constructor
     * @param repo repo to interact with
     */
    Interactor(Repository repo) {
        myRepository = repo;
    }

    /**
     * getter for repo
     * @return repo
     */
    Repository getRepository() {
        return myRepository;
    }
}
