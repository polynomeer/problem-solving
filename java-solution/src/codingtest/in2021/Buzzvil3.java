package codingtest.in2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BuzzvilSolution3_v1 {

    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        int candidate = 0;

        for (Integer skill : skills) {
            if (skill >= minLevel && skill <= maxLevel) candidate++;
        }

        if (candidate == minPlayers) return 1;
        double result = Math.pow(2, candidate) - Math.pow(2, minPlayers - 1);
        return (int) result;
    }

}

class BuzzvilSolution3_v1_fixed {
    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        int candidate = 0;
        for (Integer skill : skills) {
            if (skill >= minLevel && skill <= maxLevel) {
                candidate++;
            }
        }

        int total = 0;
        for (int i = minPlayers; i <= candidate; i++) {
            total += combination(candidate, i);
        }

        return total;
    }

    private static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;
        int result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}

class BuzzvilSolution3_v2 {
    public static int countTeams(List<Integer> skills, int minPlayers, int minLevel, int maxLevel) {
        // 1. 유효한 선수만 필터링
        List<Integer> filtered = new ArrayList<>();
        for (int skill : skills) {
            if (skill >= minLevel && skill <= maxLevel) {
                filtered.add(skill);
            }
        }

        int total = 0;
        int n = filtered.size();

        // 2. 가능한 조합의 수 계산
        // 비트마스크 사용하여 부분집합 탐색
        for (int bit = 1; bit < (1 << n); bit++) {
            int count = Integer.bitCount(bit);
            if (count >= minPlayers) {
                total++;
            }
        }

        return total;
    }
}


public class Buzzvil3 {
    public static void main(String[] args) {
        runTest(Arrays.asList(12, 4, 6, 13, 5, 10), 3, 4, 10, 5);
        runTest(Arrays.asList(4, 8, 5, 6), 1, 5, 7, 3);
        runTest(Arrays.asList(4, 8, 5, 6), 2, 5, 7, 1);
        runTest(Arrays.asList(4, 8, 5, 6), 2, 7, 8, 0);
    }

    private static void runTest(List<Integer> skills, int minPlayers, int minLevel, int maxLevel, int expected) {
        int result = BuzzvilSolution3_v2.countTeams(skills, minPlayers, minLevel, maxLevel);
        boolean passed = result == expected;
        System.out.printf("Test %s\n", passed ? "PASSED" : "FAILED");
        System.out.println("Skills: " + skills);
        System.out.printf("minPlayers = %d, minLevel = %d, maxLevel = %d\n", minPlayers, minLevel, maxLevel);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println();
    }
}
