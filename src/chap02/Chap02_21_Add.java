package chap02;

/**
 * Created by yaodh on 2015/1/2.
 */
public class Chap02_21_Add {
    int output(int number) {
        int left = 1, count = 0;
        for (int i = 2; i < Math.sqrt(2 * number); i++) {
            if ((number - left) % i == 0) {
                count++;
                for (int j = (number - left) / i; j < (number - left) / i + i; j++) {
                    System.out.printf("%d ", j);
                }
                System.out.println();
            }
            left += i;
        }
        return count;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ": ");
            new Chap02_21_Add().output(i);
        }
    }
}
