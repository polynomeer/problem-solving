package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC_14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String answer = "";
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int minLength = strs[0].length();

        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return answer;
                }
            }
            answer += strs[0].charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"cir", "car"}));
        System.out.println(longestCommonPrefix(new String[]{}));
    }
}
