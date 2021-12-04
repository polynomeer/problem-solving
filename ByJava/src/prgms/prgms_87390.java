package prgms;

import java.util.Arrays;

class Solution_87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = i + 1;
                arr[j][i] = i + 1;
            }
        }

        int[] arr2 = new int[n * n];

        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, arr2, n * i, arr[i].length);
        }

        int idx =0;
        for (int i = (int)left; i <= (int)right; i++) {
            answer[idx++] = arr2[i];
        }

        return answer;
    }
}

public class prgms_87390 {
    public static void main(String[] args) {
        Solution_87390 sol = new Solution_87390();
        System.out.println(Arrays.toString(sol.solution(3, 2, 5)));
        System.out.println(Arrays.toString(sol.solution(4, 7, 14)));
    }
}
