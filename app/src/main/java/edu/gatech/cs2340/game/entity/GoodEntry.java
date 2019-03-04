package edu.gatech.cs2340.game.entity;

import android.util.Log;

import edu.gatech.cs2340.game.models.Model;

/**
 * A representation of a good in the marketplace
 */
public class GoodEntry {
    private String itemName;
    private int itemPrice;
    private int shipInventory;
    private int marketInventory;

    public GoodEntry(String itemName, int itemPrice, int shipInventory, int marketInventory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.shipInventory = shipInventory;
        this.marketInventory = marketInventory;
    }

    @Override
    public String toString() { return itemName + ": " + itemPrice + "..."; }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getShipInventory() {
        return shipInventory;
    }

    public int getMarketInventory() {
        return marketInventory;
    }

    public void buyGood(int amount) {
        try {
            //marketInventory -= amount;
            Model.getInstance().getPlayerInteractor().buy(itemName, amount);
            shipInventory += amount;
        } catch (Exception error) {
            Log.i("Error", error.toString());
        }
        //do actual logic here
    }

    public void sellGood(int amount) {
        if (shipInventory >= amount) {
            shipInventory -= amount;
            //marketInventory += amount;
            Model.getInstance().getPlayerInteractor().sell(itemName, amount);
            //do actual logic here
        }
    }
}