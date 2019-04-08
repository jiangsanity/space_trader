package edu.gatech.cs2340.game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.cs2340.game.entity.Planet;
import edu.gatech.cs2340.game.entity.SolarSystem;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RachelUnitTest {
    private SolarSystem system;
    private Planet p1;
    private Planet p2;
    private Planet p3;
    private Planet p4;
    private Planet p5;

    @Before
    public void setUP() {
        system = new SolarSystem("Bocc");
        p1 = new Planet("Earth");
        p2 = new Planet("Mars");
        p3 = new Planet("Gru");
        p4 = new Planet("Madeniny");
        p5 = new Planet("Alidrew");

        system.addPlanet(p1);
        system.addPlanet(p2);
        system.addPlanet(p3);
        system.addPlanet(p4);
        system.addPlanet(p5);
    }
    @Test
    public void addition_isCorrect() { assertEquals(4, 2 + 2); }

    @Test
    public void testRemovePlanet() {
        system.removePlanet(p1.getName());
        system.removePlanet(p3.getName());
        List<Planet> expected = new ArrayList<>();
        expected.add(p2);
        expected.add(p4);
        expected.add(p5);
        assertEquals(expected, system.getPlanets());
    }
}