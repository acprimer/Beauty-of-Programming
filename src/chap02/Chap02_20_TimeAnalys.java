package chap02;

/**
 * Created by yaodh on 2015/1/1.
 */
public class Chap02_20_TimeAnalys {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] rg = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        for (long i = 1; i < Long.MAX_VALUE; i++) {
            int hit = 0;
            int hit1 = -1;
            int hit2 = -1;
            for (int j = 0; j < rg.length && hit <= 2; j++) {
                if (i % rg[j] != 0) {
                    hit++;
                    if (hit == 1) {
                        hit1 = j;
                    } else if (hit == 2) {
                        hit2 = j;
                    } else {
                        break;
                    }
                }
            }
            if (hit == 2 && hit1 + 1 == hit2) {
                System.out.println(i);
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
