package edu.gatech.cs2340.game.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PriceLog {

    private List<String> items;
    private int[] ipl;
    private int[] prices;
    private int[] varRate;

    public PriceLog(TechLevels s) {
        items = Arrays.asList(new String[]{"water", "furs", "food", "ore", "games", "firearms"
                , "medicine", "machines", "narcotics", "robots"});
        ipl = new int[]{3, 10, 5, 20, -10, -75, -20, -30, -125, -150};
        prices = new int[]{30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000};
        varRate = new int[]{4, 10, 5, 10, 5, 100, 10, 5, 150, 100};
        increaseByTL(s);
        increaseByVar();
    }

    public int getPrice(String item) {
        return prices[items.indexOf(item)];
    }


    private void increaseByTL(TechLevels tl) {
        for(int i = 0; i < 10; i++) {
            int newprice = prices[i] + (tl.getDescriptionID() * ipl[i]);
            prices[i] = newprice;
        }
    }

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
