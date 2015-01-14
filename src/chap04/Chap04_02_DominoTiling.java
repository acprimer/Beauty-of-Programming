package chap04;

/**
 * Created by yaodh on 2015/1/14.
 */
public class Chap04_02_DominoTiling {
    // 1*2 -> 2*n
    int fib(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
