package prgms;

import java.util.Arrays;

class Solution_72411 {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        return answer;
    }
}

public class prgms_72411 {
    public static void main(String[] args) {
        Solution_72411 sol = new Solution_72411();
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
