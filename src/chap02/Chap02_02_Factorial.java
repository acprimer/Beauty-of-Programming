package chap02;

/**
 * Created by yaodh on 2014/12/19.
 */
public class Chap02_02_Factorial {
    /**
     * 计算N!结尾有多少个0
     * Time: O(log5(num))
     */
    public int count_1(int x) {
        int ans = 0;
        while (x != 0) {
            x /= 5;
            ans += x;
        }
        return ans;
    }

    /**
     * 计算二进制表示的N!结尾有多少个0
     * Time: O(log(num))
     */
    public int count_base_2(int x) {
        int ans = 0;
        while (x != 0) {
            x >>= 1;
            ans += x;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Chap02_02_Factorial().count_1(100);
        System.out.println(ans);
    }
}
