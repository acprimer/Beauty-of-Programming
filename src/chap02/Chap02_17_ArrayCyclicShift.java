package chap02;

/**
 * Created by yaodh on 2014/12/30.
 */
public class Chap02_17_ArrayCyclicShift {
    void cyclicShift(int[] numbers, int k) {
        if (k == 0 || k == numbers.length) {
            return;
        }
        int n = numbers.length;
        for (int i = n - k; i < n; i++) {
            int idx = i - (n - k);
            int last = numbers[i];
            numbers[i] = numbers[i-k];
            while (idx < n) {
                int tmp = numbers[idx];
                numbers[idx] = last;
                last = tmp;
                idx += k;
            }
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
