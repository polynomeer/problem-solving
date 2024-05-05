package codility;

class MinAvgTwoSliceSolution {
    public int solution(int[] A) {
        int[] sums = new int[A.length];
        sums[0] = A[0];

        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }

        double min = 987654321;
        int answer = 0;
        for (int i = 1; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                double avg = (double) (sums[j] - sums[i - 1]) / (j - i + 1);

                System.out.println(sums[j] + " - " + sums[i - 1] + " / " + (j - i + 1));
                System.out.printf("slice(%d,%d) : %.1f\n", i, j, avg);

                if (min > avg) {
                    min = avg;
                    answer = i;
                }

            }
        }

        return answer;
    }
}


public class MinAvgTwoSlice {
    public static void main(String[] args) {
        MinAvgTwoSliceSolution sol = new MinAvgTwoSliceSolution();
        System.out.println(sol.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }
}
