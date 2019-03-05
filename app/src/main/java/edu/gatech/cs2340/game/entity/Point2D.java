package edu.gatech.cs2340.game.entity;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Objects;

public class Point2D {
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static double distance(Point2D p1, Point2D p2) {
        return Math.hypot(p1.getX() - p2.getX(), p2.getY() - p2.getY());
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x &&
                y == point2D.y;
    }

    @Override
    public int hashCode() {
        int tmp = ( y +  ((x+1)/2));
        return x +  ( tmp * tmp);
    }


}
