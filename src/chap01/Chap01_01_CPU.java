package chap01;

/**
 * Created by yaodh on 2015/3/25.
 */
public class Chap01_01_CPU {
    public static void main(String[] args) {
        int busyTime = 10;
        int idleTime = busyTime;
        long startTime = 0;
        while(true) {
            startTime = System.currentTimeMillis();
            while(System.currentTimeMillis() - startTime <= busyTime) {

            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
