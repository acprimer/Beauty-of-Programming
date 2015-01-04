package chap03;

/**
 * Created by yaodh on 2015/1/3.
 */
public class Chap03_01_StringShiftSearch {
    boolean shiftSearch(String source, String target) {
        if (source.length() < target.length()) {
            return false;
        }
        source += source;
        // 也可以直接调用 return source.contains(target);
        return search(source, target);
    }

    boolean search(String source, String target) {
        if (source.length() < target.length()) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < source.length() && j < target.length(); i++) {
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        return j >= target.length();
    }

    boolean shiftSearch_2(String source, String target) {
        if (source.length() < target.length()) {
            return false;
        }
        int sLen = source.length();
        int tLen = target.length();
        int j = 0;
        for (int i = 0; i < sLen * 2 && j < tLen; i++) {
            if (source.charAt(i % sLen) == target.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        return j >= tLen;
    }

    public static void main(String[] args) {
        boolean ans = new Chap03_01_StringShiftSearch().shiftSearch_2("aabcd", "cdaab");
        System.out.println(ans);
    }
}
