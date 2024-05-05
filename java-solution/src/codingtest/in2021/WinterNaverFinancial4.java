package codingtest.in2021;

import java.util.*;

class WinterNaverFinancial4Solution {

    int[][] arr;
    boolean[][] visited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    int n;
    int answer;

    public int solution(int[][] board) {
        answer = 0;
        n = board.length;
        arr = board;
        visited = new boolean[n][n];
        visited[0][0] = true;

        BFS(0, 0);

        return answer;
    }

    private void BFS(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));

        while (!q.isEmpty()) {
            Position pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (visited[nx][ny] || arr[nx][ny] == 0) {
                    continue;
                }

                q.add(new Position(nx, ny));
                if (arr[nx][ny] == 0) {

                }
                arr[nx][ny] += arr[pos.x][pos.y];
                visited[nx][ny] = true;
            }
        }
        System.out.println("Arrays.deepToString(arr) = " + Arrays.deepToString(arr));
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class WinterNaverFinancial4 {
    public static void main(String[] args) {
        WinterNaverFinancial4Solution sol = new WinterNaverFinancial4Solution();
        System.out.println(sol.solution(new int[][]{{1, -7, -2, 1, -1}, {2, 3, 0, -1, -2}, {1, -1, 6, -1, -2}, {-1, 1, -2, 0, 4}, {-10, 5, -3, -1, 1}}));
    }

}
