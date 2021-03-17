package codility;

import java.util.Arrays;

class PermMissingElemSolution {
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i+1]) {
                return A[i] + 1;
            }
        }
        return 0;
    }
}

public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElemSolution sol = new PermMissingElemSolution();
        System.out.println(sol.solution(new int[]{2, 3, 1, 5}));
    }
}
