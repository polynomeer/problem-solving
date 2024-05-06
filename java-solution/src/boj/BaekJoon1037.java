package boj;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1037 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int max = -987654321;
        int min = 987654321;

        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        stringBuilder.append(max * min);
        bufferedWriter.write(stringBuilder.toString());
        bufferedReader.close();
        bufferedWriter.close();
    }
}

