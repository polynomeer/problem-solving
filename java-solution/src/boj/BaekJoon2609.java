package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int gcd = gcd(n, m);
        int lcm = n * m / gcd;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(gcd).append('\n');
        stringBuilder.append(lcm).append('\n');
        bufferedWriter.write(stringBuilder.toString());

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}
