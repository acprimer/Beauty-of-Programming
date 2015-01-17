package chap04;

/**
 * Created by yaodh on 2015/1/16.
 */
public class Chap04_06_BlackWhiteBalls {
    // ture: white  false: black
    boolean balls(int n) {
        boolean ans = true ^ false;
        for (int i = 0; i < n - 1; i++) {
            ans ^= true;
            ans ^= false;
        }
        return ans;
    }

    /**
     * @param n white balls
     * @param m black balls
     * @return remaining ball's color
     */
    boolean balls(int n, int m) {
        boolean ans = true;
        for (int i = 0; i < n - 1; i++) {
            ans ^= true;
        }
        for (int i = 0; i < m; i++) {
            ans ^= false;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Chap04_06_BlackWhiteBalls().balls(100));
        System.out.println(new Chap04_06_BlackWhiteBalls().balls(99));
        System.out.println(new Chap04_06_BlackWhiteBalls().balls(1, 1));
        System.out.println(new Chap04_06_BlackWhiteBalls().balls(2, 1));
        System.out.println(new Chap04_06_BlackWhiteBalls().balls(2, 2));
    }
}
