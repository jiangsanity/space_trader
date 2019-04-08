package edu.gatech.cs2340.game;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import edu.gatech.cs2340.game.entity.Planet;
import edu.gatech.cs2340.game.entity.PlanetNames;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GenRandomNameTest {
    @Test
    public void test_planet_creation() {
        PlanetNames.refreshUsed();
        Planet p1 = new Planet(PlanetNames.randomPlanetName());
        Planet p2 = new Planet(PlanetNames.randomPlanetName());
        Planet p3 = new Planet(PlanetNames.randomPlanetName());
        Planet p4 = new Planet(PlanetNames.randomPlanetName());

        Set<String> list = new HashSet<>();
        list.add(p1.getName());
        list.add(p2.getName());
        list.add(p3.getName());
        list.add(p4.getName());
        assertEquals(list.size(), 4);

        for(String s : list) {
            assertTrue(isAlphaNumeric(s));
        }
    }

    @Test
    public void test_name_refresh() {
        PlanetNames.refreshUsed();
        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < 119; i++) {
            testSet.add(PlanetNames.randomPlanetName());
        }
        assertEquals(testSet.size(), 119);
    }

    @Test
    public void test_name_alpha() {
        PlanetNames.refreshUsed();
        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            assertTrue(isAlphaNumeric(PlanetNames.randomPlanetName()));
        }
    }

    public boolean isAlphaNumeric(String s){
        String pattern= "^[a-zA-Z]*$";
        return s.matches(pattern);
    }
}