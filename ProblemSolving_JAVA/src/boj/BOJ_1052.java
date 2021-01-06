package boj;

import java.util.Scanner;

public class BOJ_1052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;

        if (n <= k) {
            System.out.println(0);
            return;
        }

        while (n > k) {
            int bottle = addBottle(n);
            if (bottle <= k) {
                System.out.println(answer);
                return;
            }
            answer++;
            n++;
        }

        System.out.println(-1);
    }

    private static int addBottle(int n) {
        int bottle = 0;
        while (n > 0) {
            if (n % 2 == 1) bottle++;
            n = n / 2;
        }
        return bottle;
    }
}
