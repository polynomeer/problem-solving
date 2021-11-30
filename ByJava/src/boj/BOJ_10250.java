package boj;

import java.util.Scanner;

public class BOJ_10250 {
    private static String solve(int h, int w, int n) {
        int floor = n % h;
        int number = n / h + 1;
        if (n % h == 0) {
            floor = h;
            number = n / h;
        }
        return String.format("%d%02d", floor, number);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] answers = new String[T];

        for (int testcase = 0; testcase < T; testcase++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            answers[testcase] = solve(H, W, N);
        }

        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
