package boj;

import java.util.Scanner;

public class BaekJoon11729 {
    private static final StringBuilder sb = new StringBuilder();

    private static void hanoi(int n, int start, int to, int via) {
        if (n == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, start, via, to);
        sb.append(start).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sb.append((int) Math.pow(2, n) - 1).append('\n');
        hanoi(n, 1, 3, 2);
        System.out.print(sb);
    }
}
