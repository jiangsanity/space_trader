package edu.gatech.cs2340.game.entity;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        fuelCellLevel -= Point2D.distance(s.getPos(), currentSS.getPos());
        currentSS = s;
    }

//    public void fly(SolarSystem s, Planet p) {
//
//    }

    public void refuel() {
        this.fuelCellLevel = maxFuelCapacity;
    }

}
