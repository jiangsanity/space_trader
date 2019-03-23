package edu.gatech.cs2340.game.entity;

import java.util.List;

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
     */
    public Player(String name, int difficulty, int pilotPoints, int fighterPoints, int traderPoints,
                  int engineerPoints, Ship ship) {
        this.name = name;
        this.difficulty = difficulty;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = ship;
        this.balance = 2000;
    }

    public Player() {
        this("No Name", -1, -1, -1, -1,
                -1, new Ship("Gnat", 20, 4000));
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
     * Setter method for ship type
     *
     * @param ship type of ship the player owns
     */

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void buy(String item, int n) {
        int itemPrice = ship.getCurrentSS().getMarketplace().getPrice(item);
        for(int i = 0; i < n; i++) {
            if ((itemPrice) > balance) throw new IllegalArgumentException("Not Enough Money");
            balance -= ship.buy(item);
        }
    }

    public void sell(String item, int n) {
        for(int i = 0; i < n; i++) {
            balance += ship.sell(item);
        }
    }

    public List<SolarSystem> getAvailableFlyPoints() {
        return ship.getAvailableFlyPoints();
    }

    public void fly(SolarSystem s) {
        ship.fly(s);
    }

    public void refuel() {
        int cost = ship.refuel();
        if(cost > balance) {
            System.out.println("Balance too low to refuel!");
        } else {
            balance -= cost;
            System.out.println("Successful Refuel");
        }
    }
}
