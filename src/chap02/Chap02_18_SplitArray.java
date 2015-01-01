package chap02;

/**
 * Created by yaodh on 2015/1/1.
 */
public class Chap02_18_SplitArray {
    int splitArray(int[] numbers) {
        int ans = 0;
        int n = numbers.length;
        int[][] dp = new int[n / 2][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            dp[0][i] = numbers[i];
            sum += numbers[i];
        }
        for (int i = 1; i < n / 2; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i - 1; k < j; k++) {
                    if (dp[i - 1][k] + numbers[j] <= sum / 2 && dp[i - 1][k] + numbers[j] > dp[i][j]) {
                        dp[i][j] = dp[i - 1][k] + numbers[j];
                    }
                }
            }
        }
        for (int i = n / 2 - 1; i < n; i++) {
            ans = Math.max(ans, dp[n / 2 - 1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Chap02_18_SplitArray().splitArray(new int[]{1, 5, 7, 8, 9, 6, 3, 11, 20, 17});
        System.out.println(ans);
    }
}
