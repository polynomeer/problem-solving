package boj;

import java.util.Scanner;

public class BOJ_2798 {
    static int minGap = 987654321;
    static int answer = 0;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        m = scanner.nextInt();
        int[] cards = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = scanner.nextInt();
        }
        combination(cards, visited, 0, n, 3);

        System.out.println(answer);
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
                sum += arr[i];
            }
        }
        if (sum <= m && (m - sum) < minGap) {
            minGap = m - sum;
            answer = sum;
        }
        System.out.println();
    }
}

