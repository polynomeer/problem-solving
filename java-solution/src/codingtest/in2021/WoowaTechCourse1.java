package codingtest.in2021;

import java.util.Arrays;

class WoowaTechCourse1Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[3];
        int[] count = new int[4];
        int max = 0;

        for (int i : arr) {
            count[i]++;
        }

        for (int i = 1; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] < max) {
                answer[i - 1] = max - count[i];
            }
        }

        return answer;
    }
}

public class WoowaTechCourse1 {
    public static void main(String[] args) {
        WoowaTechCourse1Solution sol = new WoowaTechCourse1Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{2, 1, 3, 1, 2, 1})));
        System.out.println(Arrays.toString(sol.solution(new int[]{3, 3, 3, 3, 3, 3})));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3})));
    }
}
