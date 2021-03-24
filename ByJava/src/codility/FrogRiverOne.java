package codility;

class FrogRiverOneSolution {
    public int solution(int X, int[] A) {
        int[] leaves = new int[X + 1];

        for (int i = 0; i < A.length; i++) {
            leaves[A[i]]++;
            if (checkPossible(X, leaves)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkPossible(int x, int[] leaves) {
        for (int i = 1; i < x + 1; i++) {
            if (leaves[i] == 0) {
                return false;
            }
        }
        return true;
    }
}

public class FrogRiverOne {
    public static void main(String[] args) {
        FrogRiverOneSolution sol = new FrogRiverOneSolution();
        System.out.println(sol.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
        System.out.println(sol.solution(5, new int[]{1, 3, 1, 4, 2, 3, 4}));
    }
}
