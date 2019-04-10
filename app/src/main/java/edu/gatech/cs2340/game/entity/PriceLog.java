package edu.gatech.cs2340.game.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PriceLog {

    private final List<String> items;
    private final int[] ipl;
    private final int[] prices;
    private final int[] varRate;

    /**
     * Constructor for pricelog for a marketplace
     * @param s tech level to base pricelog off of
     */
    public PriceLog(TechLevels s) {
        items = Arrays.asList("water", "furs", "food", "ore", "games", "firearms"
                , "medicine", "machines", "narcotics", "robots");
        ipl = new int[]{3, 10, 5, 20, -10, -75, -20, -30, -125, -150};
        prices = new int[]{30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000};
        varRate = new int[]{4, 10, 5, 10, 5, 100, 10, 5, 150, 100};
        increaseByTL(s);
        increaseByVar();
    }

    /**
     * returns price of item in pricelog
     * @param item to look up price for
     * @return price of item
     */
    public int getPrice(String item) {
        return prices[items.indexOf(item)];
    }

    /**
     * list available items for sale
     * @return list of items for sale
     */
    public List<String> getItems() {
        return items;
    }

    /**
     * increases prices by tech level
     * @param tl tech level to base off of
     */
    private void increaseByTL(TechLevels tl) {
        for(int i = 0; i < 10; i++) {
            int newprice = prices[i] + (tl.getDescriptionID() * ipl[i]);
            prices[i] = newprice;
        }
    }

    /**
     * increases prices by random occurance to upper limit
     */
    private void increaseByVar() {
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            double factor = rand.nextInt(varRate[i] + 1);
            factor = (factor / 100) + 1;
            int newprice = (int)(prices[i] * factor);
            prices[i] = newprice;
        }
    }

}
