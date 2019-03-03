package edu.gatech.cs2340.game.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriceLog {

    private List<String> items;
    private int[] ipl;
    private int[] prices;

    public PriceLog(SolarSystem s) {
        items = Arrays.asList(new String[]{"water", "furs", "food", "ore", "games", "firearms"
                , "medicine", "machines", "narcotics", "robots"});
        ipl = new int[]{3, 10, 5, 20, -10, -75, -20, -30, -125, -150};
        prices = new int[]{30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000};
        increaseByTL(s.getTechLevel());
    }

    public int getPrice(String item) {
        return prices[items.indexOf(item)];
    }


    public void increaseByTL(TechLevels tl) {
        for(int i = 0; i < 10; i++) {
            int newprice = prices[i] + (tl.getDescriptionID() * ipl[i]);
            prices[i] = newprice;
        }
    }
}
