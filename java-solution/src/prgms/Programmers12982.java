package prgms;

import java.util.Arrays;

class Solution12982 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int i;

        for (i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) break;
        }
        return i;
    }
}

public class Programmers12982 {
    public static void main(String[] args) {
        Solution12982 sol = new Solution12982();
        System.out.println(sol.solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(sol.solution(new int[]{2, 2, 3, 3}, 10));
    }
}
