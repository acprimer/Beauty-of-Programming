package chap02;

/**
 * Created by yaodh on 2014/12/18.
 */
public class Chap02_01_NumberOfOnes {
    /**
     * 计算一个二进制数中1的个数
     * Time: O(log2(num))
     * @param x 一个字节的无符号整数 [0...255];
     * @return
     */
    public int count_1(int x) {
        int ans = 0;
        while (x != 0) {
            ans += (x % 2);
            x /= 2;
        }
        return ans;
    }

    // Time: O(log2(num))
    public int count_2(int x) {
        int ans = 0;
        while (x != 0) {
            ans += (x & 0x01);
            x >>= 1;
        }
        return ans;
    }

    // Time: O(M) M是num的二进制中1的个数
    public int count_3(int x) {
        int ans = 0;
        while (x != 0) {
            x &= (x - 1);
            ans++;
        }
        return ans;
    }

    /**
     * 练习2：计算A和B的二进制表示中有多少位是不同的？
     * Time: 同count_2()
     */
    public int exercise_2(int A, int B) {
        return count_2(A ^ B);
    }

    public static void main(String[] args) {
        int ans = new Chap02_01_NumberOfOnes().count_1(27);
        System.out.println(ans);
    }

}