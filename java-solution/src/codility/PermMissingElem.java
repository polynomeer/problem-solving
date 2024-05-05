package codility;

import java.util.Arrays;

class PermMissingElemSolution {
    public int solution(int[] A) {
        Arrays.sort(A);
        if (A.length == 0) return 1;
        if (A[0] != 1 ) return 1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i+1]) {
                return A[i] + 1;
            }
        }
        return A.length + 1;
    }
}

public class PermMissingElem {
    public static void main(String[] args) {
        PermMissingElemSolution sol = new PermMissingElemSolution();
        System.out.println(sol.solution(new int[]{2, 3, 1, 5}));
        System.out.println(sol.solution(new int[]{2, 3, 4, 5}));
        System.out.println(sol.solution(new int[]{2, 3, 4, 1}));
        System.out.println(sol.solution(new int[]{3, 1}));
        System.out.println(sol.solution(new int[]{1}));
    }
}
