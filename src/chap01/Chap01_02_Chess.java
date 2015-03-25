package chap01;

/**
 * Created by yaodh on 2015/3/25.
 */
public class Chap01_02_Chess {
    public static void main(String[] args) {
        for (int num = 0; num <= 0x88; num++) {
            if (num % 16 < 9 && num % 16 % 3 != (num / 16 % 3)) {
                System.out.println("A: " + num % 16 + " B: " + num / 16);
            }
        }
    }
}
