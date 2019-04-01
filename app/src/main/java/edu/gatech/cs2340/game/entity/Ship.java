package edu.gatech.cs2340.game.entity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a player's ship
 *
 */

public class Ship {
    private String name;
    private int maxFuelCapacity;
    private int fuelCellLevel;
    private int distancePerCell;
    private int cargoSpace;
    private int cargoUsed;
    private HashMap<String, Integer> inventory;


    private SolarSystem currentSS;
    private List<SolarSystem> availableFlyPoints;


    /**
     * Constructs a new ship
     *
     * @param name the name of the ship
     * @param cargoSpace the available cargo space in the ship
     * @param maxFuelCapacity the maximum fuel capacity
     */
    public Ship(String name, int cargoSpace, int maxFuelCapacity) {
        this.name = name;
        this.cargoSpace = cargoSpace;
        this.maxFuelCapacity = maxFuelCapacity;
        fuelCellLevel = maxFuelCapacity;
        distancePerCell = 10000;
        inventory = new HashMap<>();
    }

    /**
     * Adds values to ship attributes when save method is called
     *
     * @param prefs the values of the attributes of ship when the game was saved
     */

    public Ship(SharedPreferences prefs) {
        name = prefs.getString("sName", "ShipName");
        maxFuelCapacity = prefs.getInt("maxFuel", 2000);
        fuelCellLevel = prefs.getInt("fuelLevel", 2000);
        distancePerCell = 10000;
        cargoSpace = prefs.getInt("cargoSpace", 1000);
        cargoUsed = prefs.getInt("cargoUsed", 0);
        inventory = restoreHashMap("inventory", prefs);
        currentSS = Universe.getSystemsMap().get(prefs.getString("currentSS", ""));
    }

    /**
     * Getter method for the name of the ship
     *
     * @return the name of the ship
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name of the ship
     * @param name the name of the ship
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for fuel cell level
     *
     * @param fuelCellLevel the level of fuel in the ship
     */

    public void setFuelCellLevel(int fuelCellLevel) {
        this.fuelCellLevel = fuelCellLevel;
    }

    /**
     * Getter method for the ship's available cargo space
     *
     * @return the cargo space available
     */
    public int getCargoSpace() {
        return cargoSpace;
    }

    /**
     * Getter method for amount of cargo that is used by the ship
     * @return the amount cargo used by the ship
     */
    public int getCargoUsed() {
        return cargoUsed;
    }

    /**
     * Getter method for the current solar system's name
     *
     * @return the name of the current solar system
     */
    public SolarSystem getCurrentSS() {
        return currentSS;
    }

    /**
     * Setter method for the name of the current solar system
     *
     * @param currentSS the current solar system the player is in
     */
    public void setCurrentSS(SolarSystem currentSS) {
        this.currentSS = currentSS;
    }

    /**
     * Getter method for the maximum fuel capacity of the ship
     *
     * @return the max fuel capacity of the ship
     */
    public int getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    /**
     * Getter method for ship fuel cell level
     *
     * @return amount of fuel cell level for ship
     */
    public int getFuelCellLevel() {
        return fuelCellLevel;
    }

    /**
     * Getter method for distance per cell
     *
     * @return the distance per cell
     */
    public int getDistancePerCell() {
        return distancePerCell;
    }

    /**
     * Getter method for available fly points ship has to travel to different solar system
     *
     * @return the amount of available fly points
     */
    public List<SolarSystem> getAvailableFlyPoints() {
        if(availableFlyPoints == null) {
            generateFlyPoints();
        }
        return availableFlyPoints;
    }

    /**
     * Method that allows player to sell items
     *
     * @param item the item the player wants to sell from their ship
     * @return the price of the item the player wants to sell
     */
    public int sell(String item) {
        try {
            if(!inventory.containsKey(item) || inventory.get(item) == 0) throw new IllegalArgumentException();
            inventory.put(item, inventory.get(item) - 1);
            if(inventory.get(item) == 0) inventory.remove(item);
        } catch (IllegalArgumentException e) {
            System.out.println("Item does not exist in inventory");
        }
        cargoUsed--;
        return currentSS.getMarketplace().getPrice(item);
    }

    /**
     * Method that allows player to buy items
     *
     * @param item the item the player wants to buy
     * @return the price of the item
     */
    public int buy(String item) {
        if(cargoUsed == cargoSpace) throw new IllegalArgumentException("No more space");
        if(inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + 1);
        } else {
            inventory.put(item, 1);
        }
        cargoUsed++;
        return currentSS.getMarketplace().getPrice(item);
    }

    /**
     * Getter method for current stock
     *
     * @param good the item you are interested in seeing the stock of
     * @return number of the item available for purchase
     */
    public int getCurrentStock(String good) {
        try {
            return inventory.get(good);
        } catch(NullPointerException error) {
            return 0;
        }
    }

    /**
     * Method that generates fly points when current available fly points are too low
     *
     */
    public void generateFlyPoints() {
        availableFlyPoints = new ArrayList<>();
        Point2D curLoc = currentSS.getPos();
        int maxTravel = fuelCellLevel * distancePerCell;
        for(SolarSystem s : Universe.getSystems()) {
            if(Point2D.distance(s.getPos(), curLoc) <= maxTravel) {
                availableFlyPoints.add(s);
            }
        }
    }

    /**
     * Method that allows the ship/player to fly to a different solar system
     *
     * @param s solar system to travel to
     */
    public void fly(SolarSystem s) {
        fuelCellLevel -= getFlyCost(s);
        currentSS = s;
        generateFlyPoints();
    }

    /**
     * Getter method for the cost (fly points) it takes to fly to a different solar system
     *
     * @param s solar system to fly to
     * @return the cost (fly points) it takes to fly to the other solar system
     */
    public int getFlyCost(SolarSystem s) {
        return (int)(Point2D.distance(s.getPos(), currentSS.getPos()) / distancePerCell);
    }

    /**
     * Method to refuel the ship when fuel is too low
     *
     * @return whether or not the ship needs to be refueled
     */
    public boolean refuel() {
        if (fuelCellLevel == maxFuelCapacity) {
            return false;
        }
        fuelCellLevel = maxFuelCapacity;
        generateFlyPoints();
        return true;
    }

    /**
     * Method to get the price of the refuel
     *
     * @return the standard refuel cost value
     */
    public int getRefuelCost() {
        return 100;
    }

    /**
     * Save method for ship
     *
     * @param prefs the ship values to be saved for the next time the app is opened
     */
    public void saveShip(SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("sName", name);
        editor.putInt("maxFuel", maxFuelCapacity);
        editor.putInt("fuelLevel", fuelCellLevel);
        editor.putInt("cargoSpace", cargoSpace);
        editor.putInt("cargoUsed", cargoUsed);
        editor.putString("currentSS", currentSS.getName());

        editor.apply();
        saveHashMap("inventory", inventory, prefs);

    }

    //credit: https://freakycoder.com/android-notes-41-how-to-save-and-get-hashmap-into-sharedpreference-e686ead94b6c
    public void saveHashMap(String key , Object obj, SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        editor.putString(key,json);
        editor.apply();
    }

    //credit: https://freakycoder.com/android-notes-41-how-to-save-and-get-hashmap-into-sharedpreference-e686ead94b6c
    public HashMap<String, Integer> restoreHashMap(String key, SharedPreferences prefs) {
        Gson gson = new Gson();
        String json = prefs.getString(key,"");
        java.lang.reflect.Type type = new TypeToken<HashMap<String, Integer>>(){}.getType();
        HashMap<String, Integer> obj = gson.fromJson(json, type);
        return obj;
    }
}
