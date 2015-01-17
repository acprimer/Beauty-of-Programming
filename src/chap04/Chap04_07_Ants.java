package chap04;

/**
 * Created by yaodh on 2015/1/17.
 */
public class Chap04_07_Ants {
    int[] maxminTime(int len, int[] position) {
        int[] ans = new int[2];
        ans[0] = ans[1] = 0;
        for (int x : position) {
            ans[0] = Math.max(ans[0], Math.min(x, len - x));
            ans[1] = Math.max(ans[1], Math.max(x, len - x));
        }
        return ans;
    }

    /**
     * cal the falling time of each ant
     *
     * @param len       total length of the stick
     * @param position  sorted position of each ant
     * @param direction true ->  false <-
     * @return falling time
     */
    int[] eachTime(int len, int[] position, boolean[] direction) {
        int nAnts = position.length;
        int[] fallingTime = new int[nAnts];
        int k = 0;
        for (int i = 0; i < nAnts; i++) {
            if (!direction[i]) {
                fallingTime[k++] = position[i];
            }
        }
        k = nAnts - 1;
        for (int i = nAnts - 1; i >= 0; i--) {
            if (direction[i]) {
                fallingTime[k--] = len - position[i];
            }
        }
        return fallingTime;
    }

    public static void main(String[] args) {
        int[] ans = new Chap04_07_Ants().maxminTime(27, new int[]{3, 7, 11, 17, 23});
        System.out.println(ans[0] + " " + ans[1]);
        int[] fallingTime = new Chap04_07_Ants().eachTime(27,
                new int[]{3, 7, 11, 17, 23},
                new boolean[]{true, false, false, true, false});
        for (int time : fallingTime) {
            System.out.println(time);
        }
    }
}
