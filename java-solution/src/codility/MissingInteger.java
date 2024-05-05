package codility;

import java.util.Arrays;

class MissingIntegerSolution {
    public int solution(int[] A) {
        int value = 1;
        Arrays.sort(A);

        for (int i : A) {
            if (i == value) {
                value++;
            }
        }

        return value;
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
