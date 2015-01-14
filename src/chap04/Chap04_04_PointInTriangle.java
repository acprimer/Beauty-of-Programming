package chap04;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yaodh on 2015/1/13.
 */
public class Chap04_04_PointInTriangle {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean isInTriangle(Point[] polygon, Point point) {
        int nPoints = polygon.length;
        int dir = product(polygon[nPoints - 1], polygon[0], point) >= 0 ? 1 : -1;
        for (int i = 0; i < nPoints - 1; i++) {
            if (product(polygon[i], polygon[i + 1], point) * dir < 0) {
                return false;
            }
        }
        return true;
    }

    int product(Point A, Point B, Point C) {
        return (C.x - A.x) * (C.y - B.y) - (C.x - B.x) * (C.y - A.y);
    }

    public static void main(String[] args) {
        Chap04_04_PointInTriangle solution = new Chap04_04_PointInTriangle();
        Point A = solution.new Point(0, 0);
        Point B = solution.new Point(2, 0);
        Point C = solution.new Point(0, 2);
        Point D = solution.new Point(0, 2);
        boolean ans = solution.isInTriangle(new Point[]{A, B, C}, D);
        System.out.println(ans);
    }
}
