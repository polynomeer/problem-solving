package codingtest.in2020;

import java.util.Arrays;

class PrgmsWinterCoding3Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int[][] map;
    int[][] checked;
    int n;
    int count = 0;

    public PrgmsWinterCoding3Solution(int[][] map) {
        this.map = map;
        this.n = map.length;
        this.checked = new int[n][n];
    }

    public int[] solution(int[][] v) {
        int[] answer = new int[3];
//        System.out.println(Arrays.deepToString(v));
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if (checked[i][j] == 0) {
                    count = 0;
                    dfs(v[i][j], i, j);
//                    System.out.printf("v[%d][%d] " + v[i][j] + " count " + count + "\n", i, j);
                    if (count > 0) {
                        answer[v[i][j]]++;
                    }
                    if (count == 0 && v[i][j] != 0) {
                        answer[v[i][j]]++;
                    }
                }
            }
        }
        return answer;
    }

    private void dfs(int key, int x, int y) {
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[nx][ny] == key && checked[nx][ny] == 0) {
                    checked[nx][ny] = 1;
                    count++;
                    dfs(key, nx, ny);
                }
            }
        }

    }
}

public class PrgmsWinterCoding3 {
    public static void main(String[] args) {
        int[][] v1 = new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}, {2, 2, 2, 1}, {0, 0, 0, 2}};
        PrgmsWinterCoding3Solution sol1 = new PrgmsWinterCoding3Solution(v1);
        System.out.println(Arrays.toString(sol1.solution(v1)));

        int[][] v2 = new int[][]{{0, 0, 1}, {2, 2, 1}, {0, 0, 0}};
        PrgmsWinterCoding3Solution sol2 = new PrgmsWinterCoding3Solution(v2);
        System.out.println(Arrays.toString(sol2.solution(v2)));

        int[][] v3 = new int[][]{{0, 0, 1}, {2, 2, 2}, {0, 1, 0}};
        PrgmsWinterCoding3Solution sol3 = new PrgmsWinterCoding3Solution(v3);
        System.out.println(Arrays.toString(sol3.solution(v3)));
    }
}

