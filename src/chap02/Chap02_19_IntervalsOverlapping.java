package chap02;

import java.util.*;

/**
 * Created by yaodh on 2015/1/1.
 */
public class Chap02_19_IntervalsOverlapping {
    class Interval {
        int start, end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    boolean isIntervalsOverlapping(Interval[] target, Interval source) {
        if (target.length <= 0) {
            return false;
        }
        int n = merge(target);
        return search(target, source, n);
    }

    int merge(Interval[] target) {
        Arrays.sort(target, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start > b.start ? 1 : -1;
            }
        });
        int len = 0;
        for (int i = 1; i < target.length; i++) {
            if (target[i].start > target[len].end) {
                target[++len] = target[i];
            } else if (target[i].end > target[len].end) {
                target[len].end = target[i].end;
            }
        }
        return len + 1;
    }

    private boolean search(Interval[] target, Interval source, int n) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (source.start >= target[mid].start && source.end <= target[mid].end) {
                return true;
            }
            if (source.start >= target[mid].start) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    Interval[] generateArray() {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(2, 3);
        intervals[1] = new Interval(1, 2);
        intervals[2] = new Interval(3, 9);
        return intervals;
    }

    public static void main(String[] args) {
//        Interval[] intervals = new Chap02_19_IntervalsOverlapping().generateArray();
//        Interval source = new Chap02_19_IntervalsOverlapping().new Interval(1,6);
//        boolean ans = new Chap02_19_IntervalsOverlapping().isIntervalsOverlapping(intervals, source);
//        System.out.println(ans);

        Chap02_19_IntervalsOverlapping solution = new Chap02_19_IntervalsOverlapping();
        Rectangle[] rects = solution.generateRectangle();
        Rectangle target = solution.new Rectangle(1, 1, 3, 3);
        boolean ans = new Chap02_19_IntervalsOverlapping().isRectangleOverlapping(rects, target);
        System.out.println(ans);
    }

    public Rectangle[] generateRectangle() {
        Rectangle[] rects = new Rectangle[2];
        rects[0] = new Rectangle(0, 1, 2, 3);
        rects[1] = new Rectangle(1, 0, 3, 2);
        return rects;
    }

    // 矩形覆盖
    class Rectangle {
        int x1, y1, x2, y2;

        Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    boolean isRectangleIntersect(Rectangle R, Rectangle S) {
        return R.x1 <= S.x2 && R.x2 >= S.x1 && R.y1 <= S.y2 && R.y2 >= S.y1;
    }

    private List<Integer> xCoordinate;
    private List<Integer> yCoordinate;

    boolean isRectangleOverlapping(Rectangle[] rects, Rectangle target) {
        int n = rects.length;
        xCoordinate = new ArrayList<Integer>(2 * (n + 1));
        yCoordinate = new ArrayList<Integer>(2 * (n + 1));
        boolean[][] flag = new boolean[2 * n][2 * n];

        for (int i = 0; i < n; i++) {
            addToList(rects[i]);
        }
        addToList(target);

        Collections.sort(xCoordinate);
        Collections.sort(yCoordinate);

        for (int k = 0; k <= n; k++) {
            Rectangle rect = target;
            if (k < n) {
                rect = rects[k];
            }
            for (int i = 0; i < xCoordinate.size() && xCoordinate.get(i) < rect.x2; i++) {
                if (xCoordinate.get(i) < rect.x1) {
                    continue;
                }
                for (int j = 0; j < yCoordinate.size() && yCoordinate.get(j) < rect.y2; j++) {
                    if (yCoordinate.get(j) < rect.y1) {
                        continue;
                    }
                    if (k == n && !flag[i][j]) {
                        return false;
                    }
                    flag[i][j] = true;
                }
            }
        }
        return true;
    }

    private void addToList(Rectangle rect) {
        if (!xCoordinate.contains(rect.x1)) {
            xCoordinate.add(rect.x1);
        }
        if (!xCoordinate.contains(rect.x2)) {
            xCoordinate.add(rect.x2);
        }
        if (!yCoordinate.contains(rect.y1)) {
            yCoordinate.add(rect.y1);
        }
        if (!yCoordinate.contains(rect.y2)) {
            yCoordinate.add(rect.y2);
        }
    }
}
