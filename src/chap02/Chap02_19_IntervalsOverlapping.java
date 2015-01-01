package chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        Interval[] intervals = new Chap02_19_IntervalsOverlapping().generateArray();
        Interval source = new Chap02_19_IntervalsOverlapping().new Interval(1,6);
        boolean ans = new Chap02_19_IntervalsOverlapping().isIntervalsOverlapping(intervals, source);
        System.out.println(ans);
    }
}
