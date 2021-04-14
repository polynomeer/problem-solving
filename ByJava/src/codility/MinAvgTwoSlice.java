package codility;

class MinAvgTwoSliceSolution {
    public int solution(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];

        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + A[i];
            System.out.println(sums[i]);
        }

        int min = 987654321;
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                int avg = sums[j] - sums[i] / (j - i);
                min = Math.min(min, avg);
            }
        }

        return min;
    }
}


public class MinAvgTwoSlice {
    public static void main(String[] args) {
        MinAvgTwoSliceSolution sol = new MinAvgTwoSliceSolution();
        System.out.println(sol.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }
}
