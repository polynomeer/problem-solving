package codility;

import java.util.Arrays;

class PermCheckSolution {
    public int solution(int[] A) {
        int value = 1;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++, value++) {
            if (value == A[i]) continue;
            return 0;
        }
        return 1;
    }
}


public class PermCheck {
    public static void main(String[] args) {
        PermCheckSolution sol = new PermCheckSolution();
        System.out.println(sol.solution(new int[]{4, 1, 3, 2}) == 1);
        System.out.println(sol.solution(new int[]{4, 1, 3}) == 0);

    }
}
