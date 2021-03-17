package codility;

class TapeEquilibriumSolution {
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
    }
}

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibriumSolution sol = new TapeEquilibriumSolution();
        System.out.println(sol.solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(sol.solution(new int[]{2000, 4000}));
        System.out.println(sol.solution(new int[]{1, 3, 4, 1, 6}));
    }
}
