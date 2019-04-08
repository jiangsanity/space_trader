/*

Author: Jake Present

 */

package edu.gatech.cs2340.game;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.game.entity.GoodEntry;
import edu.gatech.cs2340.game.entity.Player;
import edu.gatech.cs2340.game.entity.PriceLog;
import edu.gatech.cs2340.game.entity.Ship;
import edu.gatech.cs2340.game.models.Model;
import edu.gatech.cs2340.game.models.PlayerInteractor;
import edu.gatech.cs2340.game.models.UniverseInteractor;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BuyItemUnitTest {

    @Test
    public void test_buy() {
        //initialize values
        PlayerInteractor pInteractor = Model.getInstance().getPlayerInteractor();
        Player player = new Player();
        player.setName("Test");
        player.setDifficulty(3);
        player.setPilotPoints(3);
        player.setFighterPoints(3);
        player.setTraderPoints(3);
        player.setEngineerPoints(3);
        pInteractor.updatePlayer(player);
        Ship newShip = new Ship("Gnat", 20, 4000);
        UniverseInteractor uInteractor = Model.getInstance().getUniverseInteractor();
        uInteractor.initializeUniverse();
        newShip.setCurrentSS(uInteractor.getRandomSS());
        pInteractor.addNewShip(newShip);

        PriceLog pricelog = new PriceLog(newShip.getCurrentSS().getTechLevel());
        List<GoodEntry> goodsList = new ArrayList<>();
        for (String good : pricelog.getItems()) {
            goodsList.add(new GoodEntry(good, pricelog.getPrice(good), newShip.getCurrentStock(good), 9999));
        }
        int expectedBalance = player.getBalance();

        //test default values
        assertEquals(pInteractor.getPlayer().getBalance(), expectedBalance);
        assertEquals(newShip.getCargoSpace(), 20);
        assertEquals(newShip.getCargoUsed(), 0);

        //test buying 1 item
        goodsList.get(0).buyGood(1);

        expectedBalance -= newShip.getCurrentSS().getMarketplace()
                .getPrice(goodsList.get(0).getItemName());

        assertEquals(pInteractor.getPlayer().getBalance(), expectedBalance);

        assertEquals(newShip.getCurrentStock(goodsList.get(0).getItemName()), 1);
        assertEquals(newShip.getCargoUsed(), 1);

        //test buying 2 items
        goodsList.get(1).buyGood(2);

        expectedBalance -= 2 * newShip.getCurrentSS().getMarketplace()
                .getPrice(goodsList.get(1).getItemName());

        assertEquals(pInteractor.getPlayer().getBalance(), expectedBalance);

        assertEquals(newShip.getCurrentStock(goodsList.get(1).getItemName()), 2);
        assertEquals(newShip.getCargoUsed(), 3);

        //test buying fail
        goodsList.get(2).buyGood(20);
        assertEquals(newShip.getCurrentStock(goodsList.get(2).getItemName()), 0);
        assertEquals(newShip.getCargoUsed(), 3);
        assertEquals(pInteractor.getPlayer().getBalance(), expectedBalance);

    }
}