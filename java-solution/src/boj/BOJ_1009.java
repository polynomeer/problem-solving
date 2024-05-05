package boj;

import java.util.Scanner;

public class BOJ_1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] answer = new int[T];

        for (int i = 0; i < T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            answer[i] = getComputerNumber(a, b);
        }

        for (int ans : answer) {
            System.out.println(ans);
        }

        sc.close();
    }

    private static int getComputerNumber(int a, int b) {
        int answer = 1;
        int digit = a % 10;
        int pow = 0;

        if (digit == 0 || digit == 1 || digit == 5 || digit == 6) {
            answer = digit;
        }
        if (digit == 2 || digit == 3 || digit == 7 || digit == 8) {
            pow = b % 4 == 0 ? 4 : b;
        }
        if (digit == 4 || digit == 9) {
            pow = b % 2 == 0 ? 2 : b;
        }

        for (int i = 0; i < pow; i++) answer = (answer * a) % 10;
        if (answer == 0) return 10;
        return answer;
    }
}
