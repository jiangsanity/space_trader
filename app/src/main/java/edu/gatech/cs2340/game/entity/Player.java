package edu.gatech.cs2340.game.entity;

import android.content.SharedPreferences;

import java.util.List;

/**
 * Represents a space trader Player
 */
public class Player {
    private String name;
    private int difficulty;
    private int pilotPoints;
    private int fighterPoints;
    private int traderPoints;
    private int engineerPoints;
    private Ship ship;

    private int balance;

    /**
     * Constructs a new player
     * @param name the name of the player
     * @param difficulty the difficulty of the game
     * @param pilotPoints number of points for pilot skill
     * @param fighterPoints number of points for fighter skill
     * @param traderPoints number of points for trader skill
     * @param engineerPoints number of points for engineering skill
     * @param ship the type of ship the player owns
     * @param balance the amount of money the player has in their account
     */
    public Player(String name, int difficulty, int pilotPoints, int fighterPoints, int traderPoints,
                  int engineerPoints, int balance, Ship ship) {
        this.name = name;
        this.difficulty = difficulty;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = ship;
        this.balance = balance;
    }

    /**
     * Assigns initial values to the constructor
     */
    public Player() {
        this("No Name", -1, -1, -1, -1,
                -1, 2000, new Ship("Gnat", 20, 4000));
    }

    /**
     * Adds values to player attributes when save method is called
     *
     * @param prefs the values of the attributes of player when the game was saved
     */
    public Player(SharedPreferences prefs) {
        this( prefs.getString("pName", "PlayerName"),
        prefs.getInt("pDiff", 0),
        prefs.getInt("pPoints", 0),
        prefs.getInt("fPoints", 0),
        prefs.getInt("tPoints", 0),
        prefs.getInt("ePoints", 0),
        prefs.getInt("pBalance", 9999),
        new Ship(prefs));
    }

    /**
     * Override toString method to output player attributes
     *
     * @return player attribute string
     */
    @Override
    public String toString() {
        return "Name: " + name + "\nDifficulty: " + difficulty + "\nPilot Points: " + pilotPoints
                + "\nFighter Points: " + fighterPoints + "\nTrader Points: " + traderPoints
                + "\nEngineer Points: " + engineerPoints;
    }

    /**
     * Getter method for player's balance
     *
     * @return the player's balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Getter method for player name
     *
     * @return the name of the player
     */

    public String getName() {
        return name;
    }

    /**
     * Getter method for game difficulty
     *
     * @return the chosen difficulty of the game
     */

    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Getter method for pilot points
     *
     * @return the number of points for pilot skill
     */

    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * Getter method for fighter points
     *
     * @return the number of points for fighter skill
     */

    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * Getter method for trader points
     *
     * @return the number of points for trader skill
     */

    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * Getter method for engineering points
     *
     * @return the number of points for engineering skill
     */

    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * Getter method for all points combined
     *
     * @return an array of the points for each skill
     */

    public int[] getAllPoints() {
        return  new int[]{ pilotPoints, fighterPoints, traderPoints, engineerPoints};
    }

    /**
     * Getter method for ship type
     *
     * @return the type of ship the player owns
     */

    public Ship getShip() {
        return ship;
    }

    /**
     * Setter method for player name
     *
     * @param name the player's name
     */


    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for game difficulty
     *
     * @param difficulty the game's difficulty
     */

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Setter method for pilot points
     *
     * @param pilotPoints points dedicated to pilot skill
     */

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * Setter method for fighter points
     *
     * @param fighterPoints points dedicated to fighter skill
     */

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * Setter method for trader points
     *
     * @param traderPoints points dedicated to trader skill
     */

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * Setter method for engineering points
     *
     * @param engineerPoints points dedicated to engineering skill
     */

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    /**
     * Setter method for the player's balance
     *
     * @param balance the player's money balance
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Setter method for ship type
     *
     * @param ship type of ship the player owns
     */

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /**
     * Method that allows player to buy any number of an item
     *
     * @param item the item the player wants to buy
     * @param n the number of the item the player wants to buy
     */
    public void buy(String item, int n) {
        int itemPrice = ship.getCurrentSS().getMarketplace().getPrice(item);
        for(int i = 0; i < n; i++) {
            if ((itemPrice) > balance) throw new IllegalArgumentException("Not Enough Money");
            balance -= ship.buy(item);
        }
    }

    /**
     * Method that allows player to sell any number of an item
     *
     * @param item the item the player wants to sell
     * @param n the number of items the player wants to sell
     */
    public void sell(String item, int n) {
        for(int i = 0; i < n; i++) {
            balance += ship.sell(item);
        }
    }

    /**
     * Method that gets the player's available fly points
     *
     * @return the number of available fly points the player has
     */
    public List<SolarSystem> getAvailableFlyPoints() {
        return ship.getAvailableFlyPoints();
    }

    /**
     * Getter method for fuel cell level
     *
     * @return the ship's available fuel cell level
     */
    public int getFuelCellLevel() {
        return ship.getFuelCellLevel();
    }

    /**
     * Method that allows player to fly to another solar system
     *
     * @param s the solar system the player wants to travel to
     */
    public void fly(SolarSystem s) {
        ship.fly(s);
    }

    /**
     * Getter method for the cost (fly points) it takes to fly to another solar system
     *
     * @param s the solar system the player wants to travel to
     * @return the cost it takes to fly to other solar system
     */
    public int getFlyCost(SolarSystem s) {
        return ship.getFlyCost(s);
    }

    /**
     * Method that allows player to refuel their ship
     *
     */
    public void refuel() {
        int cost = ship.getRefuelCost();
        if(cost > balance) {
            System.out.println("Balance too low to refuel!");
        } else {
            if (ship.refuel()) {
                balance -= cost;
            }
            System.out.println("Successful Refuel");
        }
    }

    /**
     * Method that saves player's information before they exit the app
     * @param prefs the player values to be saved for the next time the app is opened
     */
    public void savePlayer(SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("pName", name);
        editor.putInt("pDiff", difficulty);
        editor.putInt("pPoints", pilotPoints);
        editor.putInt("fPoints", fighterPoints);
        editor.putInt("tPoints", traderPoints);
        editor.putInt("ePoints", engineerPoints);
        editor.putInt("pBalance", balance);
        editor.apply();
        ship.saveShip(prefs);
    }
}
