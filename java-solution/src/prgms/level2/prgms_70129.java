package prgms.level2;

import java.util.Arrays;

class Solution_70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int length = s.length();
            s = s.replace("0", "");
            removed += length - s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }

        answer[0] = count;
        answer[1] = removed;
        return answer;
    }

}

public class prgms_70129 {
    public static void main(String[] args) {
        Solution_70129 sol = new Solution_70129();
        System.out.println(Arrays.equals(sol.solution("110010101001"), new int[]{3, 8}));
        System.out.println(Arrays.equals(sol.solution("01110"), new int[]{3, 3}));
        System.out.println(Arrays.equals(sol.solution("1111111"), new int[]{4, 1}));
    }
}
