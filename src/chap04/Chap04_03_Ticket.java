package chap04;

/**
 * Created by yaodh on 2015/1/12.
 */
public class Chap04_03_Ticket {
    // catalan number
    int ticket(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        int ans = new Chap04_03_Ticket().ticket(4);
        System.out.println(ans);
    }
}
