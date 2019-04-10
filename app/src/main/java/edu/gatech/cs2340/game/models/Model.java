package edu.gatech.cs2340.game.models;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private final Repository myRepository;

    private final Map<String, Object> interactorMap;

    private static final Model instance = new Model();

    /**
     * Model singleton constructor
     */
    private Model() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    /**
     * instance of model singleton getter
     * @return singleton of model
     */
    public static Model getInstance() {
        return instance;
    }

    /**
     * puts different interactors onto map
     */
    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
        interactorMap.put("Universe", new UniverseInteractor(myRepository));
    }

    /**
     * getter from interactor map for player
     * @return player interactor
     */
    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }
    /**
     * getter from interactor map for universe
     * @return universe interactor
     */
    public UniverseInteractor getUniverseInteractor() {
        return (UniverseInteractor) interactorMap.get("Universe");
    }

}
