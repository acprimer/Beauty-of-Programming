package chap02;

/**
 * Created by yaodh on 2014/12/21.
 */
public class Chap02_04_Ones {

    public int digitCounts(int n) {
        int ans = 0;
        int power = 1;
        int higher = 0, lower = 0;
        while (n != 0) {
            int digit = n % 10;
            higher = n / 10;
            ans += (higher + (digit > 1 ? 1 : 0)) * power;
            if (digit == 1) {
                ans += lower + 1;
            }
            lower += power * digit;
            power *= 10;
            n /= 10;
        }
        return ans;
    }

    public int digitCounts(int k, int n) {
        int ans = 0, product = 1, lower = 0;
        while (n != 0) {
            int digit = n % 10;
            int higher = n / 10;
            int cnt = (digit > k) ? (higher + 1) : higher;
            if (k == 0 && product > 1) {
                cnt--;
            }
            ans += cnt * product;
            if (digit == k) {
                ans += lower + 1;
            }
            lower += digit * product;
            product *= 10;
            n /= 10;
        }
        return ans;
    }

    public int digitCountsBinary(int n) {
        int ans = 0;
        int wei = 0;
        int higher = 0, lower = 0;
        while (n != 0) {
            int digit = n & 0x01;
            higher = n >> 1;
            if (digit == 0) {
                ans += (higher << wei);
            } else {
                ans += ((higher << wei) | lower) + 1;
            }
            lower += (digit << wei);
            wei++;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Chap02_04_Ones().digitCountsBinary(i));
        }
        int ans = new Chap02_04_Ones().digitCounts(11);
        System.out.println(ans);
    }
}
