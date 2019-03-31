package edu.gatech.cs2340.game.entity;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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


    public Ship(String name, int cargoSpace, int maxFuelCapacity) {
        this.name = name;
        this.cargoSpace = cargoSpace;
        this.maxFuelCapacity = maxFuelCapacity;
        fuelCellLevel = maxFuelCapacity;
        distancePerCell = 10000;
        inventory = new HashMap<>();
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFuelCellLevel(int fuelCellLevel) {
        this.fuelCellLevel = fuelCellLevel;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public int getCargoUsed() {
        return cargoUsed;
    }

    public SolarSystem getCurrentSS() {
        return currentSS;
    }

    public void setCurrentSS(SolarSystem currentSS) {
        this.currentSS = currentSS;
    }

    public int getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public int getFuelCellLevel() {
        return fuelCellLevel;
    }

    public int getDistancePerCell() {
        return distancePerCell;
    }

    public List<SolarSystem> getAvailableFlyPoints() {
        if(availableFlyPoints == null) {
            generateFlyPoints();
        }
        return availableFlyPoints;
    }

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

    public int getCurrentStock(String good) {
        try {
            return inventory.get(good);
        } catch(NullPointerException error) {
            return 0;
        }
    }

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

    public void fly(SolarSystem s) {
        fuelCellLevel -= getFlyCost(s);
        currentSS = s;
        generateFlyPoints();
    }

    public int getFlyCost(SolarSystem s) {
        return (int)(Point2D.distance(s.getPos(), currentSS.getPos()) / distancePerCell);
    }

    public boolean refuel() {
        if (fuelCellLevel == maxFuelCapacity) {
            return false;
        }
        fuelCellLevel = maxFuelCapacity;
        generateFlyPoints();
        return true;
    }

    public int getRefuelCost() {
        return 100;
    }

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
