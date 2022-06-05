package com.marchuk0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MaxAreaTriangle {

    public static List<Point> getMaxAreaTriangle(List<Point> convexHull) {
        int n = convexHull.size();
        if (n <= 3) {
            return new ArrayList<>(convexHull);
        } else if (n == 4) {
            
        }

        int[] T1 = getRootedMaxAreaTriangleIndices(0, convexHull);
        int l1 = T1[1] - T1[0];
        int l2 = T1[2] - T1[1];
        int l3 = T1[0] + n - T1[2];

        int m;
        if (l1 >= l2 && l1 >= l3) {
            m = (T1[0] + l1 / 2) % n;
        } else if (l2 >= l1 && l2 >= l3) {
            m = (T1[1] + l2 / 2) % n;
            T1 = toIncreasing(T1[1], T1[2], T1[0], n);
        } else {
            m = (T1[2] + l3 / 2) % n;
            T1 = toIncreasing(T1[2], T1[0], T1[1], n);
        }

        int[] T2 = getRootedMaxAreaTriangleIndices(m, convexHull);
        List<Point> medianTriangle = new ArrayList<>();
        medianTriangle.add(convexHull.get(T2[0] % n));
        medianTriangle.add(convexHull.get(T2[1] % n));
        medianTriangle.add(convexHull.get(T2[2] % n));

        if (isInterleaving(T1, T2, n)) {
            Set<Point> P1 = new LinkedHashSet<>();
            Set<Point> P2 = new LinkedHashSet<>();
            add(P1, convexHull, T1[0], T2[0], n);
            add(P2, convexHull, T2[0], T1[1], n);
            add(P1, convexHull, T1[1], T2[1], n);
            add(P2, convexHull, T2[1], T1[2], n);
            add(P1, convexHull, T1[2], T2[2], n);
            add(P2, convexHull, T2[2], T1[0], n);

            P1.remove(convexHull.get(m));
            P2.remove(convexHull.get(m));

            List<Point> triangle1 = getMaxAreaTriangle(new ArrayList<>(P1));
            List<Point> triangle2 = getMaxAreaTriangle(new ArrayList<>(P2));
            if (triangleArea(triangle1, 0, 1, 2, 3) < triangleArea(triangle2, 0, 1, 2, 3)) {
                triangle1 = triangle2;
            }

            if (triangleArea(triangle1, 0, 1, 2, 3) < triangleArea(medianTriangle, 0, 1, 2, 3)) {
                triangle1 = medianTriangle;
            }

            return triangle1;
            
        } else {
            Set<Point> P = new LinkedHashSet<>();
            Point a = convexHull.get(T2[0] % n);
            Point b = convexHull.get(T2[1] % n);
            Point c1 = convexHull.get(T1[1] % n);
            Point c2 = convexHull.get(T1[2] % n);
            if (Point.getTurn(a, b, c1) == Point.Turn.COUNTER_CLOCKWISE &&
                Point.getTurn(a, b, c2) == Point.Turn.COUNTER_CLOCKWISE) {
                add(P, convexHull, T1[1], T2[0], n);
            } else {
                add(P, convexHull, T2[0], T1[0], n);
            }
            P.remove(convexHull.get(m));

            List<Point> triangle1 = getMaxAreaTriangle(new ArrayList<>(P));
            if (triangleArea(triangle1, 0, 1, 2, 3) < triangleArea(medianTriangle, 0, 1, 2, 3)) {
                triangle1 = medianTriangle;
            }
            
            return triangle1;
        }
    }

    private static void add(Set<Point> toAdd, List<Point> points, int a, int b, int n) {
        if (b < a) {
            b += n;
        }
        for (; a <= b; a++) {
            toAdd.add(points.get(a % n));
        }
    }

    private static boolean isInterleaving(int[] a, int[] b, int n) {
        int[] first = Arrays.copyOf(a, 3);
        int[] second = Arrays.copyOf(b, 3);
        for (int i = 0; i < 3; i++) {
            first[i] %= n;
            second[i] %= n;
        }
        Arrays.sort(first);
        Arrays.sort(second);

        if (first[0] > second[0]) {
            int[] temp = first;
            first = second;
            second = temp;
        }
        
        return first[0] <= second[0] && second[0] <= first[1] &&
            first[1] <= second[1] && second[1] <= first[2] &&
            first[2] <= second[2] && second[2] <= first[0] + n;
    }

    private static int[] toIncreasing(int a, int b, int c, int n) {
        a %= n;
        b %= n;
        c %= n;

        if (b < a) b += n;
        if (c < b) c += n;

        return new int[]{a, b, c};
    }

    private static int[] getRootedMaxAreaTriangleIndices(int root, List<Point> convexHull) {
        int n = convexHull.size();
        int[] ans = new int[3];
        int b = root + 1;
        int c = b + 1;
        ans[0] = root;
        ans[1] = b;
        ans[2] = c;
        while (c % n != root) {
            if (triangleArea(convexHull, root, b, c, n) <= triangleArea(convexHull, root, b, c + 1, n)) {
                c++;
            } else {
                b++;
            }

            if (triangleArea(convexHull, ans, n) <= triangleArea(convexHull, root, b, c, n)) {
                ans[1] = b;
                ans[2] = c;
            }
        }

        return ans;
    }

    private static double triangleArea(List<Point> points, int a, int b, int c, int n) {
        return triangleArea(points.get(a % n), points.get(b % n), points.get(c % n));
    }

    private static double triangleArea(List<Point> points, int[] indices, int n) {
        return triangleArea(points.get(indices[0] % n), points.get(indices[1] % n), points.get(indices[2] % n));
    }

    private static double triangleArea(Point a, Point b, Point c) {
        long distSquaredA = b.distanceSquared(c);
        long distSquaredB = a.distanceSquared(c);
        long distSquaredC = a.distanceSquared(b);

        long sum = (distSquaredA + distSquaredB + distSquaredC);
        return Math.sqrt(sum * sum - 2 * (distSquaredA * distSquaredA + distSquaredB * distSquaredB + distSquaredC * distSquaredC));
    }
}