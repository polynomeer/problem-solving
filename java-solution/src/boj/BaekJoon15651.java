package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15651 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] output = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        permutation(arr, output, 0, n, m);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static void permutation(int[] arr, int[] output, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            output[depth] = arr[i];
            permutation(arr, output, depth + 1, n, r);
        }
    }

    static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++)
            sb.append(arr[i]).append(" ");
        sb.deleteCharAt(sb.length() - 1).append('\n');
    }
}



