package codility;

/*
public int solution(int[] A) {
        int minDiff = 987654321;

        for (int p = 1; p < A.length; p++) {
        int leftSum = 0;
        for (int i = 0; i < p; i++) leftSum += A[i];

        int rightSum = 0;
        for (int i = p; i < A.length; i++) rightSum += A[i];

        int diff = leftSum - rightSum;
        diff = diff > 0 ? diff : -diff;
        minDiff = Math.min(diff, minDiff);
        }

        return minDiff;
        }*/

import java.util.Arrays;

class TapeEquilibriumSolution {
    public int solution(int[] A) {
        int[] leftSums = new int[A.length - 1];
        int[] rightSums = new int[A.length - 1];
        int[] diffs = new int[A.length - 1];
        int sum = 0;

        for (int a : A) {
            sum += a;
        }

        leftSums[0] = A[0];

        for (int i = 1; i < leftSums.length; i++) {
            leftSums[i] = leftSums[i - 1] + A[i];
        }

        rightSums[0] = sum - leftSums[0];
        diffs[0] = leftSums[0] - rightSums[0];
        diffs[0] = diffs[0] >= 0 ? diffs[0] : -diffs[0];

        for (int i = 1; i < rightSums.length; i++) {
            rightSums[i] = sum - leftSums[i];
            diffs[i] = leftSums[i] - rightSums[i];
            diffs[i] = diffs[i] >= 0 ? diffs[i] : -diffs[i];
        }

        Arrays.sort(diffs);

        return diffs[0];
    }
}

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibriumSolution sol = new TapeEquilibriumSolution();
        System.out.println(sol.solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(sol.solution(new int[]{2000, 4000}));
        System.out.println(sol.solution(new int[]{1, 1}));
        System.out.println(sol.solution(new int[]{1, 3, 4, 1, 6}));
    }
}
