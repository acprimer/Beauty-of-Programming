package chap02;

import java.util.Scanner;

/**
 * Created by yaodh on 2014/12/30.
 */
public class Chap02_15_MaxSubmatrix {
    public int maxSubArray(int[] A) {
        int ans = A[0];
        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum = Math.max(A[i], A[i] + sum);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maxSubmatrix(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] sum = new int[rows + 1][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i + 1][j] = sum[i][j] + A[i][j];
            }
        }
        for (int i = 1; i <= rows; i++) {
            for (int j = i; j <= rows; j++) {
                int[] arr = new int[columns];
                for (int k = 0; k < columns; k++) {
                    arr[k] = sum[j][k] - sum[i - 1][k];
                }
                ans = Math.max(ans, maxSubArray(arr));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] A = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = sc.nextInt();
                }
            }
            int ans = new Chap02_15_MaxSubmatrix().maxSubmatrix(A);
            System.out.println(ans);
        }
    }
}
