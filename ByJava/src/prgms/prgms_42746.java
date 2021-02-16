package prgms;

import java.util.*;

class Solution_42746 {
    public String solution(int[] numbers) {
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (int n : numbers){
            set.add(Integer.toString(n));
        }
        return combine(set);
    }

    private String combine(TreeSet<String> set){
        StringBuilder sb = new StringBuilder();
        for (String s : set){
            sb.append(s);
        }
        return sb.toString();
    }
}

public class prgms_42746 {
    public static void main(String[] args) {
        Solution_42746 sol = new Solution_42746();
        System.out.println(sol.solution(new int[]{6, 10, 2}));
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
