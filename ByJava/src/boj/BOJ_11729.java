package boj;

import java.util.Scanner;

public class BOJ_11729 {
    private static void hanoi(int n, int start, int to, int via) {
        if (n == 1) {
            System.out.println(start + " " + to);
            return;
        }
        hanoi(n - 1, start, via, to);
        System.out.println(start + " " + to);
        hanoi(n - 1, via, to, start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 1, 3, 2);
    }
}
