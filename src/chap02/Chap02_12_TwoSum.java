package chap02;

import java.util.HashMap;

/**
 * Created by yaodh on 2014/12/28.
 */
public class Chap02_12_TwoSum {
    int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer other = map.get(target - numbers[i]);
            if (other != null) {
                return new int[]{other, i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    // numbers[]已经从小到大排过序
    int[] twoSum_2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ans = new Chap02_12_TwoSum().twoSum(new int[]{5, 6, 1, 4, 7, 9, 8}, 10);
        System.out.printf("%d %d\n", ans[0], ans[1]);
        ans = new Chap02_12_TwoSum().twoSum(new int[]{1, 4, 5, 6, 7, 8, 9}, 10);
        System.out.printf("%d %d\n", ans[0], ans[1]);
    }
}
