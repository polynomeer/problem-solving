package prgms;

import java.util.Arrays;

class Solution68936 {
    int[] answer = new int[2];
    int[][] board;

    public int[] solution(int[][] arr) {
        board = arr;
        dfs(0, 0, arr.length);
        return answer;
    }

    private void dfs(int x, int y, int len) {
        boolean[] isCompressible = isCompressible(x, y, len);

        if (isCompressible[1]) {
            answer[1]++;
            return;
        }

        if (isCompressible[0]) {
            answer[0]++;
            return;
        }

        dfs(x, y, len / 2);
        dfs(x + len / 2, y, len / 2);
        dfs(x, y + len / 2, len / 2);
        dfs(x + len / 2, y + len / 2, len / 2);
    }

    private boolean[] isCompressible(int x, int y, int len) {
        boolean[] isCompressible = new boolean[2];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (board[i][j] == 1) isCompressible[1] = true;
                if (board[i][j] == 0) isCompressible[0] = true;
            }
        }
        return isCompressible;
    }

}

public class Programmers68936 {
    public static void main(String[] args) {
        Solution68936 sol = new Solution68936();
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
        System.out.println(Arrays.toString(sol.solution(new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}})));
    }
}
