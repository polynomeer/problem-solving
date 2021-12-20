package boj;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        combination(arr, visited, 0, n, m);
        bufferedWriter.write(stringBuilder.toString());
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
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

    private static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                stringBuilder.append(arr[i]).append(' ');
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).append('\n');
    }
}
