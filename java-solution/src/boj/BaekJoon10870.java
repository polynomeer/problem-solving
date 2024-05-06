package boj;

import java.util.Scanner;

public class BaekJoon10870 {
/*    private static int fibonacci(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int[] num = new int[x + 1];
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= x; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[x];
    }*/

    private static int fibonacci(int x) {
        if (x < 2) return x;
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}
