package boj;

import java.util.Scanner;

public class BOJ_10250 {
    private static void solve(int h, int w, int n) {
        int floor = n % h;
        int number = n / h + 1;
        System.out.printf("%d%02d\n", floor, number);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int testcase = 0; testcase < T; testcase++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            solve(H, W, N);
        }
    }
}
