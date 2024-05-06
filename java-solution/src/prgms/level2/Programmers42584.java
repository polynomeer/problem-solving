package prgms.level2;

import java.util.Arrays;

class Solution42584 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
}

public class Programmers42584 {
    public static void main(String[] args) {
        Solution42584 sol = new Solution42584();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 1, 2, 3, 4})));
        System.out.println(Arrays.toString(sol.solution(new int[]{2, 3, 1, 2, 1})));
    }
}
