package chap03;

/**
 * Created by yaodh on 2015/1/5.
 */
public class Chap03_03_StringSimilarity {
    int similarity(String s, String t) {
        s = "$" + s;
        t = "$" + t;
        int sLen = s.length();
        int tLen = t.length();
        int[][] dist = new int[sLen][tLen];
        for (int i = 0; i < tLen; i++) {
            dist[0][i] = i;
        }
        for (int i = 0; i < sLen; i++) {
            dist[i][0] = i;
        }
        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j < tLen; j++) {
                dist[i][j] = dist[i - 1][j - 1]
                        + (s.charAt(i) == t.charAt(j) ? 0 : 1);
                dist[i][j] = Math.min(dist[i][j],
                        Math.min(dist[i - 1][j], dist[i][j - 1]) + 1);
            }
        }
        return dist[sLen - 1][tLen - 1];
    }

    // 用滚动数组优化空间
    int similarity_2(String s, String t) {
        s = "$" + s;
        t = "$" + t;
        int sLen = s.length();
        int tLen = t.length();
        int[][] dist = new int[2][tLen];
        for (int i = 0; i < tLen; i++) {
            dist[0][i] = i;
        }
        dist[1][0] = 1;
        for (int i = 1; i < sLen; i++) {
            for (int j = 1; j < tLen; j++) {
                dist[i % 2][j] = dist[(i + 1) % 2][j - 1]
                        + (s.charAt(i) == t.charAt(j) ? 0 : 1);
                dist[i % 2][j] = Math.min(dist[i % 2][j],
                        Math.min(dist[(i + 1) % 2][j], dist[i % 2][j - 1]) + 1);
            }
        }
        return dist[(sLen + 1) % 2][tLen - 1];
    }

    public static void main(String[] args) {
        int ans = new Chap03_03_StringSimilarity().similarity_2("abd", "aabc");
        System.out.println(ans);
    }
}
