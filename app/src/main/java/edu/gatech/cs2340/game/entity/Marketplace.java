package edu.gatech.cs2340.game.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.game.models.Model;

public class Marketplace {

	private PriceLog pricelog;
    public final List<GoodEntry> goodsList = new ArrayList<>();

	/**
	 * Creates a new marketplace
	 * @param techlevel the tech level of the solar system
	 */
	public Marketplace(TechLevels techlevel) {
		pricelog = new PriceLog(techlevel);
        Ship ship = Model.getInstance().getPlayerInteractor().getPlayer().getShip();
        Log.i("Ship", ship.toString());
		for (String good : pricelog.getItems()) {
		    goodsList.add(new GoodEntry(good, getPrice(good), ship.getCurrentStock(good), 9999));
        }
	}

	public int getPrice(String item) {
		return pricelog.getPrice(item);
	}

	public int buyItem(String item) {
		return pricelog.getPrice(item);
	}

	public void priceHike(int percent) {
		for (GoodEntry e : goodsList) {
			e.itemPriceHike(percent);
		}
	}



}
