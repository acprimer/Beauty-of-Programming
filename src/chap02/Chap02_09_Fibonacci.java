package chap02;

/**
 * Created by yaodh on 2014/12/26.
 */
public class Chap02_09_Fibonacci {
    int fib_1(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    int fib_2(int n) {
        double root = Math.sqrt(5.0);
        double ans = (Math.pow((1.0 + root) / 2.0, n) - Math.pow((1.0 - root) / 2.0, n)) / root;
        return (int) ans;
    }

    int fib_3(int n) {
        int[] power = new int[]{1, 1, 1, 0};
        int[] fn = new int[]{1, 0, 1, 0};
        while (n != 0) {
            if (n % 2 != 0) {
                fn = multify(fn, power);
            }
            power = multify(power, power);
            n /= 2;
        }
        return fn[1];
    }

    private int[] multify(int[] x, int[] y) {
        int[] ans = new int[4];
        ans[0] = x[0] * y[0] + x[1] * y[2];
        ans[1] = x[0] * y[1] + x[1] * y[3];
        ans[2] = x[2] * y[0] + x[3] * y[2];
        ans[3] = x[2] * y[1] + x[3] * y[3];
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 46; i++) {
            System.out.printf("%2d: %d %d %d\n", i, new Chap02_09_Fibonacci().fib_1(i), new Chap02_09_Fibonacci().fib_2(i), new Chap02_09_Fibonacci().fib_3(i));
        }
    }
}
