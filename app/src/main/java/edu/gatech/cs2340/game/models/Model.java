package edu.gatech.cs2340.game.models;

import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.Universe;

import java.util.HashMap;
import java.util.Map;

public class Model {

    private Repository myRepository;

    private Map<String, Object> interactorMap;

    private static Model instance = new Model();

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
