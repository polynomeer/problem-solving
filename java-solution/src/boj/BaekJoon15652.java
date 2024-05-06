package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15652 {
    static int n, m;
    static int[] arr;
    static int[] sel;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[n];
        sel = new int[m];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        process(1, 0);

        bufferedWriter.write(stringBuilder.toString());
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void process(int idx, int cnt) {
        if (cnt == m) {
            int x = 0;
            for (int j = 0; j < n; j++) {
                stringBuilder.append(sel[x++]).append(" ");
                if (x == m) break;
            }
            stringBuilder.append('\n');
            return;
        }

        for (int i = idx - 1; i < n; i++) {
            sel[cnt] = arr[i];
            process(i + 1, cnt + 1);
        }
    }
}
