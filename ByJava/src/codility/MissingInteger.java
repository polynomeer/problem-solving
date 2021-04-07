package codility;

import java.util.Arrays;

class MissingIntegerSolution {
    public int solution(int[] A) {
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
        if (A[A.length - 1] <= 0) {
            return 1;
        }

        int i = 1;
        for (; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                continue;
            }
            if (A[i - 1] + 1 != A[i]) {
                return A[i] - 1;
            }
        }

        return A[i - 1] + 1;
    }
}

public class MissingInteger {
    public static void main(String[] args) {
        MissingIntegerSolution sol = new MissingIntegerSolution();
        System.out.println(sol.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(sol.solution(new int[]{1, 2, 3}));
        System.out.println(sol.solution(new int[]{-1, -3}));
    }
}
