package chap02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/1/2.
 */
public class Chap02_21_Add {
    List<List<Long>> sum(long number) {
        long left = 1, count = 0;
        List<List<Long>> ans = new ArrayList<List<Long>>();
        for (long i = 2; i < Math.sqrt(2) * Math.sqrt(number); i++) {
            if ((number - left) % i == 0) {
                count++;
                List<Long> list = new ArrayList<Long>();
                for (long j = (number - left) / i; j < (number - left) / i + i; j++) {
                    list.add(j);
                    System.out.println(j);
                }
                ans.add(list);
            }
            left += i;
        }
        System.out.println(count);
        return ans;
    }

    // O(sqrt(n))
    int sumCount(long number) {
        long left = 1;
        int count = 0;
        for (long i = 2; i < Math.sqrt(2) * Math.sqrt(number); i++) {
            if ((number - left) % i == 0) {
                count++;
            }
            left += i;
        }
        return count;
    }

    // O(n)
    int sumCount_2(long target) {
        long sum = 0;
        int count = 0;
        for (long start = 1, end = 1; start <= (target + 1) / 2; end++) {
            sum += end;
            if (sum == target) {
                count++;
            }
            while (sum >= target - end) {
                sum -= start;
                start++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long number = (long) 3 * 5 * 7 * 11 * 13 * 17 * 19 * 23 * 29 * 31 * 37 * 41 * 47 * 25 * 27;
//        long number = 987654323;
//        System.out.println(Long.MAX_VALUE / number);
        System.out.println(number + ": " + new Chap02_21_Add().sumCount_2(number));
    }
}
