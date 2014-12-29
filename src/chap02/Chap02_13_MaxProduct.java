package chap02;

/**
 * Created by yaodh on 2014/12/29.
 */
public class Chap02_13_MaxProduct {
    int maxProduct(int[] numbers) {
        int len = numbers.length;
        if (len <= 1) {
            return 0;
        }
        int ans = 0;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        leftProduct[0] = 1;
        rightProduct[len - 1] = 1;
        for (int i = 1; i < numbers.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * numbers[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * numbers[i + 1];
        }
        for (int i = 0; i < numbers.length; i++) {
            ans = Math.max(ans, leftProduct[i] * rightProduct[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Chap02_13_MaxProduct().maxProduct(new int[]{-1, 2, 1, 3, 5});
        System.out.println(ans);
    }
}
