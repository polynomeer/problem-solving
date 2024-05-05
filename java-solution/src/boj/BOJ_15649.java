package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649 {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        int[] arr = new int[n];
        int[] output = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        permutation(arr, output, visited, 0, n, m);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }

    private static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            sb.append(arr[i]).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1).append('\n');
    }
}
