package chap02;

/**
 * Created by yaodh on 2014/12/27.
 */
public class Chap02_10_FindMaxMin {
    int[] findMaxMin(int[] nums) {
        int[] maxmin = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        if (nums.length % 2 != 0) {
            maxmin[0] = maxmin[1] = nums[0];
        }
        for (int i = nums.length % 2; i < nums.length; i += 2) {
            int twoMax = nums[i];
            int twoMin = nums[i + 1];
            if (twoMax < twoMin) {
                twoMax = nums[i + 1];
                twoMin = nums[i];
            }
            maxmin[0] = Math.max(maxmin[0], twoMax);
            maxmin[1] = Math.min(maxmin[1], twoMin);
        }
        return maxmin;
    }

    int[] findMaxMin2(int[] nums, int start, int end) {
        int[] maxmin = new int[2];
        if (end - start <= 1) {
            if (nums[start] < nums[end]) {
                maxmin[0] = nums[end];
                maxmin[1] = nums[start];
            } else {
                maxmin[0] = nums[start];
                maxmin[1] = nums[end];
            }
            return maxmin;
        }
        int[] maxminL = new int[2];
        int[] maxminR = new int[2];
        int mid = (start + end) / 2;
        maxminL = findMaxMin2(nums, start, mid);
        maxminR = findMaxMin2(nums, mid + 1, end);
        if (maxminL[0] > maxminR[0]) {
            maxmin[0] = maxminL[0];
        } else {
            maxmin[0] = maxminR[0];
        }
        if (maxminL[1] < maxminR[1]) {
            maxmin[1] = maxminL[1];
        } else {
            maxmin[1] = maxminR[1];
        }
        return maxmin;
    }

    int findSecondMax(int[] nums) {
        int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        if (nums.length % 2 != 0) {
            max[0] = max[1] = nums[0];
        }
        for (int i = nums.length % 2; i < nums.length; i += 2) {
            int mmax = nums[i];
            int smax = nums[i + 1];
            if (mmax < smax) {
                mmax = nums[i + 1];
                smax = nums[i];
            }
            if (mmax > max[0]) {
                max[1] = max[0];
                max[0] = mmax;
                if (smax > max[1]) {
                    max[1] = smax;
                }
            } else {
                if (mmax > max[1]) {
                    max[1] = mmax;
                }
            }
        }
        return max[1];
    }

    public static void main(String[] args) {
        int[] ans = new Chap02_10_FindMaxMin().findMaxMin(new int[]{5, 6, 8, 3, 7, 9});
        System.out.printf("%d %d\n", ans[0], ans[1]);
        ans = new Chap02_10_FindMaxMin().findMaxMin2(new int[]{5, 6, 8, 3, 7, 9}, 0, 5);
        System.out.printf("%d %d\n", ans[0], ans[1]);
        int secondMax = new Chap02_10_FindMaxMin().findSecondMax(new int[]{5, 6, 8, 3, 7, 9, 10});
        System.out.printf("%d\n", secondMax);
    }
}
