package codingtest.in2021;

class IportfolioSolution2 {
    private static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private static int[] dy = {0, 1, 0, -1};
    private static int answer;

    public int solution(int[][] office, int r, int c, String[] move) {
        int direction = 0; // 북: 0, 동: 1, 남: 2, 서: 3
        int n = office.length;
        int x = r;
        int y = c;

        for (String m : move) {
            clean(office, x, y);
            switch (m) {
                case "go":
                    int next_x = x + dx[direction];
                    int next_y = y + dy[direction];
                    if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n
                            && office[next_x][next_y] != -1) {
                        x = next_x;
                        y = next_y;
                    }
                    break;
                case "right":
                    direction = (direction + 1) % 4;
                    break;
                case "left":
                    direction = (direction + 3) % 4;
                    break;
            }
        }
        clean(office, x, y);

        return answer;
    }

    private void clean(int[][] map, int row, int col) {
        if (map[row][col] != -1) {
            answer += map[row][col];
            map[row][col] = 0;
        }
    }
}

public class Iportfolio2 {
    public static void main(String[] args) {
        IportfolioSolution2 sol = new IportfolioSolution2();
        System.out.println(sol.solution(
                new int[][]{{5, -1, 4}, {6, 3, -1}, {2, -1, 1}}, 1, 0,
                new String[]{"go", "go", "right", "go", "right", "go", "left", "go"}
        ));
    }
}
