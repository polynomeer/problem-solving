package codingtest.in2021;

import java.util.Arrays;
import java.util.List;


class BuzzvilSolution5_v1 {

    public static int largestArea(List<List<Integer>> samples) {
        int length = samples.size();
        for (; length > 0; length--) {
            if (isSquare(samples, length)) break;
        }
        return length;
    }

    private static boolean isSquare(List<List<Integer>> matrix, int n) {
        for (int i = 0; i < matrix.size() - n; i++) {
            for (int j = 0; j < matrix.size() - n; j++) {
                if (mask(matrix, n, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean mask(List<List<Integer>> matrix, int n, int i, int j) {
        for (int row = i; row < i + n; row++) {
            for (int col = j; col < j + n; col++) {
                if (matrix.get(row).get(col) != 1) {
                    return false;
                }
            }
        }
        return true;
    }

}

class BuzzvilSolution5_v1_fixed {

    public static int largestArea(List<List<Integer>> samples) {
        int length = samples.size();
        for (; length > 0; length--) {
            if (isSquare(samples, length)) break;
        }
        return length;
    }

    private static boolean isSquare(List<List<Integer>> matrix, int n) {
        int size = matrix.size();
        for (int i = 0; i <= size - n; i++) {        // <=로 변경
            for (int j = 0; j <= size - n; j++) {    // <=로 변경
                if (mask(matrix, n, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean mask(List<List<Integer>> matrix, int n, int i, int j) {
        for (int row = i; row < i + n; row++) {
            for (int col = j; col < j + n; col++) {
                if (matrix.get(row).get(col) != 1) return false;
            }
        }
        return true;
    }
}


class BuzzvilSolution5_v2 {

    public static int largestArea(List<List<Integer>> samples) {
        int n = samples.size();
        if (n == 0) return 0;

        int[][] dp = new int[n][n];
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (samples.get(i).get(j) == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;  // 첫 행이나 첫 열은 그대로
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }

        return maxSize;
    }
}

public class Buzzvil5 {
    public static void main(String[] args) {
        runTest(Arrays.asList(
                Arrays.asList(1, 1, 1),
                Arrays.asList(1, 1, 0),
                Arrays.asList(1, 0, 1)
        ), 2);

        runTest(Arrays.asList(
                Arrays.asList(0, 1, 1),
                Arrays.asList(1, 1, 0),
                Arrays.asList(1, 0, 1)
        ), 1);

        runTest(Arrays.asList(
                Arrays.asList(1, 1, 1, 1, 1),
                Arrays.asList(1, 1, 1, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0),
                Arrays.asList(1, 1, 1, 1, 1)
        ), 3);

        runTest(Arrays.asList(
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 1, 1),
                Arrays.asList(0, 1, 1)
        ), 2);
    }

    private static void runTest(List<List<Integer>> input, int expected) {
        int result = BuzzvilSolution5_v1.largestArea(input);
        boolean passed = result == expected;
        System.out.printf("Test %s\n", passed ? "PASSED" : "FAILED");
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println();
    }
}

