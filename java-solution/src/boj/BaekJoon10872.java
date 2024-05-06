package boj;

import java.util.Scanner;

public class BaekJoon10872 {
    private static int factorial(int x) {
        if (x == 0) return 1;
        return factorial(x - 1) * x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
