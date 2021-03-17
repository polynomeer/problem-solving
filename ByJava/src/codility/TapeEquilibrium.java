package codility;

import java.util.Arrays;

class TapeEquilibriumSolution {
    public int solution(int[] A) {
        int answer = 0;
        Arrays.sort(A);
        int max = A[A.length - 1];

        if (A.length == 0) return 0;
        if (A.length == 1) return A[0];

        int index = BinarySearch(A, max);
        int leftSum = 0;
        for (int i = 0; i < index; i++) {
            leftSum += A[i];
        }
        int rightSum = 0;
        for (int i = index; i < A.length; i++) {
            rightSum += A[i];
        }
        answer = Math.abs(leftSum - rightSum);

        if (A.length == 2) return answer;

        int leftTemp = leftSum - A[index - 1];
        int rightTemp = rightSum + A[index - 1];
        int temp = Math.abs(leftTemp - rightTemp);
        if (leftTemp != 0) answer = Math.min(answer, temp);
        leftTemp = leftSum + A[index];
        rightTemp = rightSum - A[index];
        temp = Math.abs(leftTemp - rightTemp);
        if (rightTemp != 0) answer = Math.min(answer, temp);

        return answer;
    }

    private int BinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}

public class TapeEquilibrium {
    public static void main(String[] args) {
        TapeEquilibriumSolution sol = new TapeEquilibriumSolution();
        System.out.println(sol.solution(new int[]{3, 1, 2, 4, 3}));
        System.out.println(sol.solution(new int[]{2000, 4000}));
        System.out.println(sol.solution(new int[]{1, 1}));
        System.out.println(sol.solution(new int[]{1, 3, 4, 1, 6}));
    }
}
