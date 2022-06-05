package com.marchuk0;

import java.util.Objects;

public class Point {
    public enum Turn {CLOCKWISE, COUNTER_CLOCKWISE, COLLINEAR}

    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public long distanceSquared(Point other) {
        return ((long) this.x - other.x) * ((long) this.x - other.x) +
            ((long) this.y - other.y) * ((long) this.y - other.y);
    }

    public static Turn getTurn(Point a, Point b, Point c) {

        long crossProduct = ((long) b.x - a.x) * ((long) c.y - a.y) -
            ((long) b.y - a.y) * ((long) c.x - a.x);

        if (crossProduct > 0) {
            return Turn.COUNTER_CLOCKWISE;
        } else if (crossProduct < 0) {
            return Turn.CLOCKWISE;
        } else {
            return Turn.COLLINEAR;
        }
    }
}
