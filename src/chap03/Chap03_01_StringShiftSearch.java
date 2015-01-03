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
        return source.contains(target);
    }

    public static void main(String[] args) {
        boolean ans = new Chap03_01_StringShiftSearch().shiftSearch("aabcd", "cdaa");
        System.out.println(ans);
    }
}
