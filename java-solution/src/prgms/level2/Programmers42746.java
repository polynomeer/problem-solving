package prgms.level2;

import java.util.*;

class Solution42746 {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, (s1, s2) -> ((s2 + s1).compareTo(s1 + s2)));

        return str[0].equals("0") ? "0" : combine(str);
    }

    private String combine(String[] strings) {
        StringBuilder sb = new StringBuilder();

        for (String s : strings) {
            sb.append(s);
        }

        return sb.toString();
    }
}

public class Programmers42746 {
    public static void main(String[] args) {
        Solution42746 sol = new Solution42746();
        System.out.println(sol.solution(new int[]{6, 10, 2}));
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(sol.solution(new int[]{0, 0, 0, 0}));
        System.out.println(sol.solution(new int[]{21, 212}));
        System.out.println(sol.solution(new int[]{1, 1, 1, 1}));
        System.out.println(sol.solution(new int[]{12, 12}));
        System.out.println(sol.solution(new int[]{123, 123}));
    }
}
