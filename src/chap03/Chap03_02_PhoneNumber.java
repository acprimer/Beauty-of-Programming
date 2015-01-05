package chap03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/1/4.
 */
public class Chap03_02_PhoneNumber {
    public static final String[] maps = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    List<String> findWords(String phoneNumber) {
        List<String> words = new ArrayList<String>();
        words.add("");
        words = dfs(words, phoneNumber, 0);
        return words;
    }

    private List<String> dfs(List<String> words, String phoneNumber, int start) {
        if (start >= phoneNumber.length()) {
            return words;
        }
        List<String> list = new ArrayList<String>();
        int number = phoneNumber.charAt(start) - '0';
        for (String word : words) {
            for (int j = 0; j < maps[number].length(); j++) {
                list.add(word + maps[number].charAt(j));
            }
        }
        return dfs(list, phoneNumber, start + 1);
    }

    List<String> findWords_2(String phoneNumber) {
        List<String> words = new ArrayList<String>();
        words.add("");
        for (int i = 0; i < phoneNumber.length(); i++) {
            List<String> list = new ArrayList<String>();
            for (String word : words) {
                int number = phoneNumber.charAt(i) - '0';
                for (int j = 0; j < maps[number].length(); j++) {
                    list.add(word + maps[number].charAt(j));
                }
            }
            words = list;
        }
        return words;
    }

    public static void main(String[] args) {
        List<String> ans = new Chap03_02_PhoneNumber().findWords_2("456");
        for (String word : ans) {
            System.out.println(word);
        }
    }
}
