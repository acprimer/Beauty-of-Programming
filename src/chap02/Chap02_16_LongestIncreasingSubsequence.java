package chap02;

/**
 * Created by yaodh on 2014/12/31.
 */
public class Chap02_16_LongestIncreasingSubsequence {
    int LIS(int[] numbers) {
        int ans = 1;
        int n = numbers.length;
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                }
            }
            ans = Math.max(ans, len[i]);
        }
        return ans;
    }
    int LIS_2(int[] numbers) {
        int ans = 1;
        int n = numbers.length;
        int[] list = new int[n];
        list[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            if(numbers[i] > list[ans-1]) {
                list[ans++] = numbers[i];
            } else {
                int idx = search(list, numbers[i]);
                list[idx] = numbers[i];
            }
        }
        return ans;
    }

    int search(int[] list, int number) {
        for(int i=0;i<list.length;i++) {
            if(number<list[0]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int ans = new Chap02_16_LongestIncreasingSubsequence().LIS_2(new int[]{1, -1, 2, -3, 4, -5, 6, 7});
        System.out.println(ans);
    }
}
