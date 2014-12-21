package chap02;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by yaodh on 2014/12/20.
 */
public class Chap02_03_WaterKing {
    /**
     * 给一个ID数组，其中一个ID超过数组长度的一半，求出这个ID。
     * Time: O(n)
     *
     * @param ids ID数组
     * @return 超过数组长度一般的ID
     */
    public int findMost(int[] ids) {
        int candidate = -1, count = 0;
        for (int i = 0; i < ids.length; i++) {
            if (count == 0) {
                candidate = ids[i];
                count = 1;
            } else {
                if (ids[i] == candidate) count++;
                else count--;
            }
        }
        return candidate;
    }

    public int findMostStack(int[] ids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < ids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(ids[i]);
            } else {
                if (stack.peek() == ids[i]) stack.push(ids[i]);
                else stack.pop();
            }
        }
        return stack.peek();
    }

    public int find3thMost(int[] ids) {
        int[] candidates = new int[2];
        int[] count = new int[2];
        for (int i = 0; i < ids.length; i++) {
            if (count[0] == 0) {
                candidates[0] = ids[i];
                count[0]++;
            } else if (ids[i] == candidates[0]) {
                count[0]++;
            } else if (count[1] == 0) {
                candidates[1] = ids[i];
                count[1]++;
            } else if (ids[i] == candidates[1]) {
                count[1]++;
            } else {
                count[0]--;
                count[1]--;
            }
        }
        return 0;
    }

    public int majorityNumber(ArrayList<Integer> nums) {
        int[] candidates = new int[2];
        int[] count = new int[2];
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i), j;
            for (j = 0; j < 2; j++) {
                if (count[j] == 0) {
                    candidates[j] = cur;
                    count[j]++;
                    break;
                } else if (candidates[j] == cur) {
                    count[j]++;
                    break;
                }
            }
            if (j >= 2) {
                count[0]--;
                count[1]--;
            }
        }
        count[0] = count[1] = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidates[0]) {
                count[0]++;
            } else if (nums.get(i) == candidates[1]) {
                count[1]++;
            }
        }
        if (count[0] > count[1]) return candidates[0];
        else return candidates[1];
    }

    public int majorityNumber(ArrayList<Integer> nums, int k) {
        int[] candidates = new int[k];
        int[] count = new int[k];
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i), j;
            for (j = 0; j < k; j++) {
                if (count[j] == 0) {
                    candidates[j] = cur;
                    count[j]++;
                    break;
                } else if (candidates[j] == cur) {
                    count[j]++;
                    break;
                }
            }
            if (j >= k) {
                for(int idx=0;idx<k;idx++) {
                    count[idx]--;
                }
            }
        }
        for(int j=0;j<k;j++) {
            count[j]=0;
        }
        for (int i = 0; i < nums.size(); i++) {
            for(int j=0;j<k;j++) {
                if(candidates[j]==nums.get(i)) {
                    count[j]++;
                    if(count[j]>nums.size()/k) {
                        return candidates[j];
                    }
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,3,1,4,5,6,17,8,9,1};
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++) {
            nums.add(a[i]);
        }
        int ans = new Chap02_03_WaterKing().majorityNumber(nums, 10);
        System.out.println(ans);
    }
}
