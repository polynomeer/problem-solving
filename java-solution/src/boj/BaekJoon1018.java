package boj;

import java.util.Scanner;

public class BaekJoon1018 {

    private static int n;
    private static int m;
    private static char[][] chess;

    public static void getInputFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        chess = new char[n][m];

        for (int i = 0; i < n; i++) {
            String inputStr = sc.next();
            for (int j = 0; j < m; j++) {
                chess[i][j] = inputStr.charAt(j);
            }
        }
    }

    public static int mask(int x, int y, char color) {
        int paint = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (j % 2 == 0 && chess[i][j] != color) paint++;
                else if (j % 2 == 1 && chess[i][j] == color) paint++;
            }
            color = color == 'B' ? 'W' : 'B'; // put different color into next block
        }
        return paint;
    }

    public static void printChess() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getInputFromKeyboard();
        int answer = 987654321;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                answer = Math.min(answer, mask(i, j, 'W'));
                answer = Math.min(answer, mask(i, j, 'B'));
            }
        }
        System.out.println(answer);
    }
}

/*import java.util.Scanner;

public class BaekJoon1018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            System.arraycopy(chars, 0, board[i], 0, chars.length);
        }

        int min = 987654321;
        for (int i = 0; i < m - 7; i++) {
            for (int j = 0; j < n - 7; j++) {
             int paint = mask(board, i, j);
                min = Math.min(min, paint);
            }
        }
    }

    private static int mask(char[][] board, int row, int col) {
        int hit = 0;
        char curr = board[row][col];

        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                // 인접한 것끼리 비교하면서 진행하려면 너무 복잡해진다.
            }
        }
        return hit;
    }
}*/
