package prgms;

import java.util.Arrays;

class Solution_64065 {
    public int[] solution(String s) {
        int[] answer = {};
        char[] chars = s.toCharArray();
        
        return answer;
    }
}

public class prgms_64065 {
    public static void main(String[] args) {
        Solution_64065 sol = new Solution_64065();
        System.out.println(Arrays.toString(sol.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(sol.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(sol.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(sol.solution("{{123}}")));
        System.out.println(Arrays.toString(sol.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}
