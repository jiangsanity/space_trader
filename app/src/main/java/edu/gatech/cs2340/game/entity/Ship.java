package edu.gatech.cs2340.game.entity;
import java.util.HashMap;

public class Ship {
    private String name;
    private int remainingSpace;
    private int initialCargoCapacity;
    private HashMap<String, Integer> inventory;
    private int size;

    /**
     * Constructs a new ship
     * @param name the name of the player
     * @param initialCargoCapacity capacity of the ship
     */
    public Ship(String name, int initialCargoCapacity) {
        this.name = name;
        this.initialCargoCapacity = initialCargoCapacity;
        inventory = new HashMap<>();
        this.size = 0;
        this.remainingSpace = initialCargoCapacity;
    }


    /**
     * Override toString method to output player attributes
     *
     * @return player attribute string
     */
    @Override
    public String toString() {
        return "Ship: " + name + "\nTotal Cargo Hold: " + initialCargoCapacity
                + "\nRemaining Cargo Capacity: " + remainingSpace
                + "\nItems: " + getItems();
    }

    /**
     * Getter method for ship name
     *
     * @return the name the ship
     */
    public String getName() { return name; }


    /**
     * Getter method for size
     *
     * @return the number of items currently in the ship
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter method the remaining space
     *
     * @return the remaining space
     */
    public int getRemainingSpace() {
        return remainingSpace;
    }

    /**
     * Getter method for initial cargo capacity
     *
     * @return the initial cargo capacity
     */
    public int getInitialCargoCapacity() {
        return initialCargoCapacity;
    }


    /**
     * Adds item to inventory
     *
     * @param item good to be added to cargo
     */
    public void addItem(String item, int quantity) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + quantity);
        } else {
            inventory.put(item, quantity);
        }
        size = size + quantity;
        remainingSpace = remainingSpace - quantity;
    }

    /**
     * Gets a String of the items in the cargo hold
     *
     * @returm string of all items
     */
    public String getItems() {
        String str = "";
        for (String i : inventory.keySet()) {
            str+= i + ": " + inventory.get(i);
        }
        return str;
    }
}
