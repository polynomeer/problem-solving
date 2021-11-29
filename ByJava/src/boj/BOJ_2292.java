package boj;

import java.util.Scanner;

public class BOJ_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        int i = 0;

        for (; i <= n; i++) {
            sum += 6 * i;
            if (sum >= n) break;
        }

        System.out.println(i + 1);
    }
}
