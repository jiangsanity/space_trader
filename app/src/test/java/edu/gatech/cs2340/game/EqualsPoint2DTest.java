/*
  Author: Fernanda Moreno
 */
package edu.gatech.cs2340.game;

import org.junit.Test;

import edu.gatech.cs2340.game.entity.Point2D;
import edu.gatech.cs2340.game.entity.Ship;

import static org.junit.Assert.assertEquals;

public class EqualsPoint2DTest {
    @Test
    public void testEqualsPoint2d() {
        Point2D xy = new Point2D(4,5);
        Point2D xz = new Point2D(4,5);
        Point2D yz = new Point2D(9,8);
        Ship not_point2D = new Ship("Gnat", 20, 20);

        assertEquals(true, xy.equals(xz));
        assertEquals(false, xy.equals(null));
        assertEquals(false, xy.equals(not_point2D));
        assertEquals(false, xy.equals(yz));
        assertEquals(true, xy.equals(xy));
    }
}
