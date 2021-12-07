package boj;

import java.util.Scanner;

public class BOJ_10989 {
    private static final int MAX_NUM = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        int[] sorted = new int[n + 1];
        int[] count = new int[MAX_NUM + 1];
        int[] countSum = new int[MAX_NUM + 1];

        for (int i = 1; i <= n; i++) {
            int num = sc.nextInt();
            arr[i] = num;
            count[num]++;
        }

        for (int i = 1; i <= MAX_NUM; i++) {
            countSum[i] = countSum[i - 1] + count[i];
        }

        for (int i = n; i >= 1; i--) {
            sorted[countSum[arr[i]]] = arr[i];
            countSum[arr[i]]--;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(sorted[i]);
        }
    }
}
