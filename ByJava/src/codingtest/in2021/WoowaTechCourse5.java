package codingtest.in2021;

import java.util.Arrays;

class WoowaTechCourse5Solution {
    public int[][] solution(int rows, int columns) {
        int[][] answer = new int[rows][columns];
        int[][] visited = new int[rows][columns];
        int r = 0;
        int c = 0; // 2. r을 현재 위치의 행, c를 현재 위치의 열로 정의합니다.
        int number = 1;
        answer[r][c] = number; // 1. 현재 위치를 1행 1열로 정하고, 그 위치에 숫자 1을 씁니다.
        visited[r][c] = 1;

        while (!isFull(answer)) {
            if (number % 2 == 0) { // 4. 만약 가장 최근에 쓴 숫자가 짝수라면, r행 c열에서 r+1행 c열로 이동합니다. r = rows라면, 1행으로 이동합니다.
                r = r + 1;
                if (r >= rows) r = 0;
            } else { // 5. 만약 가장 최근에 쓴 숫자가 홀수라면, r행 c열에서 r행 c+1열로 이동합니다. c = columns라면, 1열로 이동합니다.
                c = c + 1;
                if (c >= columns) c = 0;
            }

            if (rows == columns && visited[r][c] > 0) break;
            if (rows == columns * 2 && visited[r][c] > 0) break;
            if (columns == rows * 2 && visited[r][c] > 0) break;

            number = number + 1; // 6. 도착한 칸에 원래 쓰여 있던 수를 지우고 가장 최근에 쓴 숫자 + 1을 씁니다.
            answer[r][c] = number;
            visited[r][c]++;
        }
        return answer;
    }

    // 3. 만약 격자 내에 0이 쓰인 칸이 없거나, 더 이상 0이 쓰여 있는 칸에 다른 숫자를 쓸 수 없게 된다면 과정을 즉시 종료합니다.
    private boolean isFull(int[][] board) {
        for (int[] line : board) {
            for (int cell : line) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class WoowaTechCourse5 {
    public static void main(String[] args) {
        WoowaTechCourse5Solution sol = new WoowaTechCourse5Solution();
        System.out.println(Arrays.deepToString(sol.solution(3, 4)));
        System.out.println(Arrays.deepToString(sol.solution(3, 3)));
        System.out.println(Arrays.deepToString(sol.solution(4, 3)));
        System.out.println(Arrays.deepToString(sol.solution(5, 3)));
        System.out.println(Arrays.deepToString(sol.solution(3, 5)));
        System.out.println(Arrays.deepToString(sol.solution(5, 5)));
        System.out.println(Arrays.deepToString(sol.solution(103, 25)));

        System.out.println(Arrays.deepToString(sol.solution(4, 4)));
        System.out.println(Arrays.deepToString(sol.solution(5, 5)));


        System.out.println(Arrays.deepToString(sol.solution(4, 2)));
        System.out.println(Arrays.deepToString(sol.solution(2, 4)));

        System.out.println(Arrays.deepToString(sol.solution(3, 6)));
        System.out.println(Arrays.deepToString(sol.solution(4, 8)));
        System.out.println(Arrays.deepToString(sol.solution(5, 10)));
        System.out.println(Arrays.deepToString(sol.solution(10, 5)));


    }
}
