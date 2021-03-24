package codility;

import java.util.HashSet;
import java.util.Set;

class FrogRiverOneSolution {
    public int solution(int X, int[] A) {
        Set<Integer> leaves = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X)
                leaves.add(A[i]);
            if (leaves.size() == X)
                return i;
        }
        return -1;
    }
}

public class FrogRiverOne {
    public static void main(String[] args) {
        FrogRiverOneSolution sol = new FrogRiverOneSolution();
        System.out.println(sol.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        System.out.println(sol.solution(5, new int[]{1, 3, 1, 4, 2, 3, 4}));
    }
}
