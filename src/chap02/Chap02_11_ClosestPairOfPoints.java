package chap02;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yaodh on 2014/12/27.
 */
public class Chap02_11_ClosestPairOfPoints {
    class Point2D {
        int x, y;
        public Point2D(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    double minDist(Point2D[] points) {
        // sort by x
        Arrays.sort(points, new Comparator<Point2D>() {
            @Override
            public int compare(Point2D p, Point2D q) {
                return p.x > q.x ? 1 : -1;
            }
        });
        Point2D[] pointsByY = new Point2D[points.length];
        for (int i = 0; i < points.length; i++) {
            pointsByY[i] = points[i];
        }

        Point2D[] aux = new Point2D[points.length];

        return closest(points, pointsByY, aux, 0, points.length - 1);
    }

    private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int start, int end) {
        if (end <= start) {
            return Double.POSITIVE_INFINITY;
        }

        int mid = start + (end - start) / 2;
        int median = pointsByX[mid].x;
        double dLeft = closest(pointsByX, pointsByY, aux, start, mid);
        double dRight = closest(pointsByX, pointsByY, aux, mid + 1, end);
        double delta = Math.min(dLeft, dRight);

        // O(n)
        merge(pointsByY, aux, start, mid, end);

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (Math.abs(pointsByY[i].x - median) < delta) {
                aux[count++] = pointsByY[i];
            }
        }
        // O(n)
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count && aux[j].y - aux[i].y < delta; j++) {
                double distance = dist(aux[i], aux[j]);
                delta = Math.min(delta, distance);
            }
        }
        return delta;
    }

    private double dist(Point2D p, Point2D q) {
        double dx = p.x - q.x;
        double dy = p.y - q.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private void merge(Point2D[] pointsByY, Point2D[] aux, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            aux[i] = pointsByY[i];
        }
        int i = start, j = mid + 1, k = start;
        while (i <= mid || j <= end) {
            if (j > end || (i <= mid && aux[i].y < aux[j].y)) {
                pointsByY[k++] = aux[i++];
            } else {
                pointsByY[k++] = aux[j++];
            }
        }
    }

    public Point2D[] generatePoints() {
        Point2D[] points = new Point2D[]{new Point2D(0, 0), new Point2D(7, 6), new Point2D(2, 20),
                new Point2D(12, 5), new Point2D(16, 16), new Point2D(5, 8)};
        return points;
    }

    public static void main(String[] args) {
        Point2D[] points = new Chap02_11_ClosestPairOfPoints().generatePoints();
        double ans = new Chap02_11_ClosestPairOfPoints().minDist(points);
        System.out.println(ans);
    }
}
