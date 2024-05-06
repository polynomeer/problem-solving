package prgms.level2;

import java.util.Arrays;

/*class Solution87390 {
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
}*/

class Solution87390 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (int i = 0; i < right - left + 1; i++) {
            long position = left + i;
            answer[i] = (int) (Long.max(position / n, position % n) + 1);
        }

        return answer;
    }
}

public class Programmers87390 {
    public static void main(String[] args) {
        Solution87390 sol = new Solution87390();
        System.out.println(Arrays.toString(sol.solution(3, 2, 5)));
        System.out.println(Arrays.toString(sol.solution(4, 7, 14)));
//        System.out.println(Arrays.toString(sol.solution(100000, 7, 80000)));
    }
}
