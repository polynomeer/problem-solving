package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SaveThePrisoner {

/*    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        Queue<Integer> chairs = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            chairs.add(i);
        }

        for (int i = 0; i < m; i++) {
            int prisoner = chairs.peek();
            if (prisoner == s) break;
            chairs.add(prisoner);
            chairs.poll();
        }
        for (int i = 1; i < m; i++) {
            chairs.add(chairs.poll());
        }
        return chairs.poll();
    }*/

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        int prisoner = (s + m - 1) % n;
        if (prisoner == 0) {
            prisoner = n;
        }
        return prisoner;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);
            int m = Integer.parseInt(nms[1]);
            int s = Integer.parseInt(nms[2]);
            int result = saveThePrisoner(n, m, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
