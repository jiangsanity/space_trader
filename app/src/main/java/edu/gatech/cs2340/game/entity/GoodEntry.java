package edu.gatech.cs2340.game.entity;

import edu.gatech.cs2340.game.models.Model;

/**
 * A representation of a good in the marketplace
 */
public class GoodEntry {
private final String itemName;
private int itemPrice;
private int shipInventory;
private final int marketInventory;
private static int shipCargoUsed;

    /**
     * Goods entry item constructor
     * @param itemName name of item
     * @param itemPrice price of item
     * @param shipInventory amount in inventory of ship
     * @param marketInventory amount in inventory of market
     */
    public GoodEntry(String itemName, int itemPrice, int shipInventory, int marketInventory) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.shipInventory = shipInventory;
        this.marketInventory = marketInventory;
    }

    /**
     * String representation of object
     * @return print string
     */
    @Override
    public String toString() { return itemName + ": " + itemPrice + "..."; }

    /**
     * itemName field getter
     * @return itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * price of item getter
     * @return price
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * get size ship inventory
     * @return size of ship inventory
     */
    public int getShipInventory() {
        shipInventory = Model.getInstance().getPlayerInteractor().getPlayer().getShip().getCurrentStock(itemName);
        return shipInventory;
    }

    /**
     * get size marketplace inventory
     * @return size of marketplace inventory
     */
    public int getMarketInventory() {
        return marketInventory;
    }

    /**
     * buys a good from marketplace to ship
     * @param amount of quantity to buy
     */
    public void buyGood(int amount) {
        try {
            //marketInventory -= amount;
            if(shipCargoUsed == Model.getInstance().getPlayerInteractor().getPlayer().getShip().getCargoSpace()) {
                throw new IllegalArgumentException();
            }
            Model.getInstance().getPlayerInteractor().buy(itemName, amount);
            shipInventory += amount;
            shipCargoUsed++;
        } catch (IllegalArgumentException e) {
            System.out.println("Error, cannot buy more than available space");
        }
    }

    /**
     * sell good from ship to marketplace
     * @param amount to sell
     */
    public void sellGood(int amount) {
        if (shipInventory >= amount) {
            shipInventory -= amount;
            //marketInventory += amount;
            Model.getInstance().getPlayerInteractor().sell(itemName, amount);
            //do actual logic here
        }
    }

    /**
     * increase price of item by a certain amount
     * @param percent amount to increase by
     */
    public void itemPriceHike(int percent) {
        this.itemPrice = itemPrice + (int)(itemPrice * (percent / 100.0));
    }
}