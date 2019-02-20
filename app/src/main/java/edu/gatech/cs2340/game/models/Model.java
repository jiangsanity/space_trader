package edu.gatech.cs2340.game.models;

import edu.gatech.cs2340.game.entity.Player;

public class Model {

    private Player p;

    private static Model instance = new Model();

    private Model() {
        p = new Player();
    }
}
