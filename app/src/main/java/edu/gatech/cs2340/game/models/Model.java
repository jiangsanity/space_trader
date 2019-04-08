package edu.gatech.cs2340.game.models;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private final Repository myRepository;

    private final Map<String, Object> interactorMap;

    private static final Model instance = new Model();

    private Model() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    public static Model getInstance() {
        return instance;
    }

    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
        interactorMap.put("Universe", new UniverseInteractor(myRepository));
    }

    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }

    public UniverseInteractor getUniverseInteractor() {
        return (UniverseInteractor) interactorMap.get("Universe");
    }

}
