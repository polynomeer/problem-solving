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
            int bottle = sumBottle(n);
            if (bottle <= k) {
                System.out.println(answer);
                return;
            }
            answer++;
            n++;
        }

        System.out.println(-1);
        sc.close();
    }

    private static int sumBottle(int n) {
        int remains = 0;
        while (n > 0) {
            if (n % 2 == 1) remains++;
            n /= 2;
        }
        return remains;
    }
}
