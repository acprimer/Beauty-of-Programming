package chap02;

/**
 * Created by yaodh on 2014/12/30.
 */
public class Chap02_17_ArrayCyclicShift {
    void cyclicShift(int[] numbers, int k) {
        int n = numbers.length;
        k %= n;
        reverse(numbers, 0, n - 1);
        reverse(numbers, 0, n - k - 1);
        reverse(numbers, n - k, n - 1);
    }

    private void reverse(int[] numbers, int start, int end) {
        for (; start < end; start++, end--) {
            int tmp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Chap02_17_ArrayCyclicShift().cyclicShift(A, 2);
        for (int x : A) {
            System.out.printf("%d ", x);
        }
    }
}
