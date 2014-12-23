package chap02;

import java.util.PriorityQueue;

/**
 * Created by yaodh on 2014/12/22.
 */
public class Chap02_05_FindKthNumber {

    public int[] findMostKthNumber(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k + 1);
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new Chap02_05_FindKthNumber().findMostKthNumber(new int[]{10, 15, 6, 8, 3}, 3);
        for (int x : ans) {
            System.out.println(x);
        }
    }
}

