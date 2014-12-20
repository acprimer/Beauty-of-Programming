package chap02;

/**
 * Created by yaodh on 2014/12/19.
 */
public class Chap02_02_Factorial {
    public int count_1(int x) {
        int ans = 0;
        while (x != 0) {
            ans += x / 5;
            x /= 5;
        }
        return ans;
    }

    public int count_base_2(int x) {
        int ans = 0;
        while (x != 0) {
            ans += x / 2;
            x /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Chap02_02_factorial().count_1(100);
        System.out.println(ans);
    }
}
