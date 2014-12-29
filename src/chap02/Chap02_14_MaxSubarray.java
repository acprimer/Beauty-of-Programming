package chap02;

/**
 * Created by yaodh on 2014/12/29.
 */
public class Chap02_14_MaxSubarray {
    public int maxSubArray(int[] A) {
        int ans = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(A[i], A[i] + sum);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
