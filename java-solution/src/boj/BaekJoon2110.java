package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon2110 {
    static int maxDist = 0;
    static int minDiff = 987654321;
    static int n;
    static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        int[] pos = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            pos[i] = sc.nextInt();
        }

        combination(pos, visited, 0, n, c);
        System.out.println(maxDist);
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
        int[] tempPos = new int[c];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                tempPos[idx++] = arr[i];
            }
        }

        Arrays.sort(tempPos);
        System.out.println(Arrays.toString(tempPos));
        int[] dist = new int[c - 1];
        for (int i = 1; i < tempPos.length; i++) {
            int diff = tempPos[i] - tempPos[i - 1];
            dist[i - 1] = diff;
            maxDist = Math.max(maxDist, diff);
        }
        System.out.println(Arrays.toString(dist));
        for (int i = 1; i < dist.length; i++) {
            int diff = dist[i] - dist[i - 1];
            if (diff < 0) diff = -diff;
            minDiff = Math.min(minDiff, diff);
        }
//        System.out.println(minDiff);


    }
}
