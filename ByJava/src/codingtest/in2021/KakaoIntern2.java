package codingtest.in2021;

import java.util.Arrays;

class KakaoIntern2Solution {
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        char[][] map = new char[places[0].length][];

        int idx = 0;
        for (String[] place : places) {
            for (int i = 0; i < place.length; i++) {
                map[i] = place[i].toCharArray();
            }
            answer[idx++] = check(map);
        }

        return answer;
    }

    private int check(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'P') {
                    if (!isOkay(map, i, j)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isOkay(char[][] map, int x, int y) {
        int n = map.length;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[nx][ny] == 'P') {
                    return false;
                }
            }
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            int nnx = x + dx[k] + dx[k];
            int nny = y + dy[k] + dy[k];
            if (0 <= nnx && nnx < n && 0 <= nny && nny < n) {
                if (map[nnx][nny] == 'P' && map[nx][ny] != 'X') {
                    return false;
                }
            }
        }

        int[] ddx = {-1, -1, 1, 1};
        int[] ddy = {-1, 1, 1, -1};

        for (int k = 0; k < 4; k++) {
            int nx = x + ddx[k];
            int ny = y + ddy[k];
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (map[nx][ny] == 'P') {
                    if (map[x][ny] != 'X' || map[nx][y] != 'X') {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void print(char[][] map) {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}


public class KakaoIntern2 {
    public static void main(String[] args) {
        KakaoIntern2Solution sol = new KakaoIntern2Solution();
        System.out.println(Arrays.toString(sol.solution(new String[][]
                {
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
                }
        )));
    }
}
