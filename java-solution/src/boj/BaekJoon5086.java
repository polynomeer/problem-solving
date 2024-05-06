package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon5086 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            if (n == 0 && m == 0) break;
            identify(n, m);
        }

        bufferedWriter.write(stringBuilder.toString());
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void identify(int n, int m) {
        if (n > m && n % m == 0) stringBuilder.append("multiple\n");
        else if (m > n && m % n == 0) stringBuilder.append("factor\n");
        else stringBuilder.append("neither\n");
    }
}
