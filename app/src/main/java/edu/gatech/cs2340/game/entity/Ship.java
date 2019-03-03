package edu.gatech.cs2340.game.entity;

import java.util.HashMap;

public class Ship {
    private String name;
    private int cargoSpace;
    private int cargoUsed;
    private HashMap<String, Integer> inventory;

    private SolarSystem currentSS;


    public Ship(String name, int cargoSpace) {
        this.name = name;
        this.cargoSpace = cargoSpace;
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
        return currentSS.getMarketplace().getPrice(item);
    }

}