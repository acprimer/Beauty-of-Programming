package chap02;

/**
 * Created by yaodh on 2014/12/18.
 */
public class _2_01_NumberOfOnes {
    public int solution(int num) {
        int ans = 0;
        while (num != 0) {
            ans += (num & 0x01);
            num >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 27;
        int ans = new _2_01_NumberOfOnes().solution(num);
        System.out.println(ans);
    }
}
