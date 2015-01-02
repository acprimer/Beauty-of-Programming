package chap02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/1/2.
 */
public class Chap02_21_Add {
    List<List<Long>> output(long number) {
        long left = 1, count = 0;
        List<List<Long>> ans = new ArrayList<List<Long>>();
        for (long i = 2; i < Math.sqrt(2) * Math.sqrt(number); i++) {
            if ((number - left) % i == 0) {
                count++;
//                List<Long> list = new ArrayList<Long>();
//                for (long j = (number - left) / i; j < (number - left) / i + i; j++) {
//                    list.add(j);
//                }
//                ans.add(list);
            }
            left += i;
        }
        System.out.println(count);
        return ans;
    }

    public static void main(String[] args) {
        long number = (long) 3 * 5 * 7 * 11 * 13 * 17 * 19 * 23 * 29 * 31 * 37 * 41 * 47 * 25 * 27;
        System.out.println(Long.MAX_VALUE/number);
        System.out.println(number + ": " + new Chap02_21_Add().output(number).size());
    }
}
