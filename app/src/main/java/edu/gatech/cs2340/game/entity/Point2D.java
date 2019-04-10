package edu.gatech.cs2340.game.entity;

import java.util.Locale;

public class Point2D {
    private final int x;
    private final int y;

    /**
     * constructor for 2D coordinate point
     * @param x x value
     * @param y y value
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * gets x value
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * gets y value
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * distance calculator between two points
     * @param p1 point a
     * @param p2 point b (destination)
     * @return distance between two points
     */
    public static double distance(Point2D p1, Point2D p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    /**
     * String representation of Point2d
     * @return string representing point
     */
    @Override
    public String toString() {
        return String.format(Locale.US, "{%d, %d}", x, y);
    }

    /**
     * check if two points are equal
     * @param o other point
     * @return if points are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x &&
                y == point2D.y;
    }

    /**
     * hashing for point
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int tmp = ( y +  ((x+1)/2));
        return x +  ( tmp * tmp);
    }


}
