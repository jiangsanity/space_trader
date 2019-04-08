/*
  Author: Fernanda Moreno
 */
package edu.gatech.cs2340.game;

import org.junit.Test;

import edu.gatech.cs2340.game.entity.Point2D;
import edu.gatech.cs2340.game.entity.Ship;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EqualsPoint2DTest {
    @Test
    public void testEqualsPoint2d() {
        Point2D xy = new Point2D(4,5);
        Point2D xz = new Point2D(4,5);
        Point2D yz = new Point2D(9,8);
        Ship not_point2D = new Ship("Gnat", 20, 20);

        assertEquals(xy, xz);
        assertNotEquals(null, xy);
        assertNotEquals(xy, not_point2D);
        assertNotEquals(xy, yz);
        assertEquals(xy, xy);
    }
}
