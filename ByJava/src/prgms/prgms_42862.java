package prgms;

import java.util.Arrays;

public class prgms_42862 {
    public static void main(String[] args) {
        Solution_42862 sol = new Solution_42862();
        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(sol.solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(sol.solution(5, new int[]{3}, new int[]{1}));
        System.out.println(sol.solution(5, new int[]{1, 3}, new int[]{2, 4}));
        System.out.println(sol.solution(3, new int[]{3}, new int[]{1}));
        System.out.println(sol.solution(3, new int[]{1, 3}, new int[]{2}));
        System.out.println(sol.solution(3, new int[]{1, 2}, new int[]{2, 3}));
    }
}

class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer1 = 0, answer2 = 0;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int r : reserve) {
            count[r - 1] = 2;
        }
        for (int l : lost) {
            count[l - 1]--;
        }
        int[] tempCount = Arrays.copyOf(count, n);
        for (int i = 1; i < n; i++) {
            if (count[i] == 0 && count[i - 1] == 2) {
                count[i - 1]--;
                count[i]++;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (count[i] == 0 && count[i + 1] == 2) {
                count[i + 1]--;
                count[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (count[i] > 0) {
                answer1++;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (tempCount[i] == 0 && tempCount[i + 1] == 2) {
                tempCount[i + 1]--;
                tempCount[i]++;
            }
        }
        for (int i = 1; i < n; i++) {
            if (tempCount[i] == 0 && tempCount[i - 1] == 2) {
                tempCount[i - 1]--;
                tempCount[i]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (tempCount[i] > 0) {
                answer2++;
            }
        }
        return Math.max(answer1, answer2);
    }
}