package edu.gatech.cs2340.game.entity;

public class Marketplace {

	private PriceLog pricelog;

	/**
	 * Creates a new marketplace
	 * @param techlevel the tech level of the solar system
	 */
	public Marketplace(TechLevels techlevel) {
		pricelog = new PriceLog(techlevel);
	}

	public int getPrice(String item) {
		return pricelog.getPrice(item);
	}

	public int buyItem(String item) {
		return pricelog.getPrice(item);
	}

}
