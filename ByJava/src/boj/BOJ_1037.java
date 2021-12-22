package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1037 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int div = 0;
        int multi = 1;

        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            multi *= num;
            div = gcd(num, div);
        }
        int answer = multi / div;
        stringBuilder.append(answer);
        bufferedWriter.write(stringBuilder.toString());
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}

