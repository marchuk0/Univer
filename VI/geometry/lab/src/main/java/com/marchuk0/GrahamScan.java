package com.marchuk0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class GrahamScan {
    public static List<Point> buildConvexHull(List<Point> points) throws IllegalArgumentException {
        if (points.size() < 3) {
            return new ArrayList<>(points);
        }

        List<Point> sorted = new ArrayList<>(getSortedPointSet(points));

        if (sorted.size() < 3) {
            return new ArrayList<>(sorted);
        }

        if (areAllCollinear(sorted)) {
            return new ArrayList<>(sorted);
        }

        Stack<Point> stack = new Stack<>();
        stack.push(sorted.get(0));
        stack.push(sorted.get(1));

        for (int i = 2; i < sorted.size(); i++) {

            Point head = sorted.get(i);
            Point middle = stack.pop();
            Point tail = stack.peek();

            Point.Turn turn = Point.getTurn(tail, middle, head);

            switch (turn) {
                case COUNTER_CLOCKWISE:
                    stack.push(middle);
                    stack.push(head);
                    break;
                case CLOCKWISE:
                    i--;
                    break;
                case COLLINEAR:
                    stack.push(head);
                    break;
            }
        }

        // close the hull
//        stack.push(sorted.get(0));

        return new ArrayList<>(stack);
    }

    private static Set<Point> getSortedPointSet(List<Point> points) {

        Point lowest = getLowestPoint(points);

        TreeSet<Point> set = new TreeSet<>(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {

                if (a == b || a.equals(b)) {
                    return 0;
                }

                double thetaA = Math.atan2((long) a.y - lowest.y, (long) a.x - lowest.x);
                double thetaB = Math.atan2((long) b.y - lowest.y, (long) b.x - lowest.x);

                if (thetaA < thetaB) {
                    return -1;
                } else if (thetaA > thetaB) {
                    return 1;
                } else {

                    long distanceA = lowest.distanceSquared(a);
                    long distanceB = lowest.distanceSquared(b);

                    if (distanceA < distanceB) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        set.addAll(points);

        return set;
    }

    private static Point getLowestPoint(List<Point> points) {
        Point res = points.get(0);

        for (int i = 1; i < points.size(); i++) {
            Point temp = points.get(i);

            if (temp.y < res.y || (temp.y == res.y && temp.x < res.x)) {
                res = temp;
            }
        }

        return res;
    }

    private static boolean areAllCollinear(List<Point> points) {

        if (points.size() < 2) {
            return true;
        }

        Point a = points.get(0);
        Point b = points.get(1);

        for (int i = 2; i < points.size(); i++) {
            Point c = points.get(i);

            if (Point.getTurn(a, b, c) != Point.Turn.COLLINEAR) {
                return false;
            }
        }

        return true;
    }


}
