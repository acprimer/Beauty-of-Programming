package chap02;

import java.util.Scanner;

/**
 * Created by yaodh on 2014/12/30.
 */
public class Chap02_15_MaxSubmatrix {

    public int maxSubmatrix(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                A[i][j] += A[i - 1][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < rows; j++) {
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    int x = A[j][k] - (i == 0 ? 0 : A[i - 1][k]);
                    sum = Math.max(x, x + sum);
                    ans = Math.max(ans, sum);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Chap02_15_MaxSubmatrix().maxSubmatrix(new int[][]{{0, -2, -7, 0}, {9, 2, -6, 2}, {-4, 1, -4, 1}, {-1, 8, 0, 2}});
        System.out.println(ans);
    }
}
