package edu.gatech.cs2340.game.entity;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.game.models.Model;

/**
 * Represents a solar system's market place
 *
 */
public class Marketplace {

	private final PriceLog pricelog;
    public final List<GoodEntry> goodsList = new ArrayList<>();

	/**
	 * Creates a new marketplace
	 * @param techlevel the tech level of the solar system
	 */
	public Marketplace(TechLevels techlevel) {
		pricelog = new PriceLog(techlevel);
        Ship ship = Model.getInstance().getPlayerInteractor().getPlayer().getShip();
        //Log.i("Ship", ship.toString());
		for (String good : pricelog.getItems()) {
		    goodsList.add(new GoodEntry(good, getPrice(good), ship.getCurrentStock(good), 9999));
        }
	}

	/**
	 * Getter method for price
	 *
	 * @param item the item in the market that we are getting the price from
	 * @return the price of the item
	 */

	public int getPrice(String item) {
		return pricelog.getPrice(item);
	}

	/**
     * Method that increases the prices of an item during a random price surge
     *
     * @param percent the percentage by which the price of item is increased
     */

	public void priceHike(int percent) {
		for (GoodEntry e : goodsList) {
			e.itemPriceHike(percent);
		}
	}



}
