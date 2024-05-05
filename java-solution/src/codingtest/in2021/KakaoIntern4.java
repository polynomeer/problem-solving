package codingtest.in2021;

import java.util.LinkedList;
import java.util.Queue;

class KakaoIntern4Solution {

    int N, M;
    int[][] check = new int[101][101];
    int[][] visit = new int[101][101];
    char[][] map = new char[101][101];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        return answer;
    }


    void BFS(int x, int y) {
        visit[x][y] = 1;
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(x, y));

        while (!queue.isEmpty()) {
            int xPos = queue.peek().x;
            int yPos = queue.peek().y;

            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                    if (map[nextX][nextY] == '1' && visit[nextX][nextY] == 0) {
                        check[nextX][nextY] = check[x][y] + 1;
                        visit[nextX][nextY] = 1;
                        queue.add(new Pos(nextX, nextY));
                    }

                }

            }
        }

    }
}

public class KakaoIntern4 {
    public static void main(String[] args) {
        KakaoIntern4Solution sol = new KakaoIntern4Solution();
        System.out.println(sol.solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2}));
        System.out.println(sol.solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }
}
