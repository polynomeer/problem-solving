package boj;

import java.util.Scanner;

public class BOJ_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int movie = 0;
        int answer = 0;

        for (int i = 0; movie < n; i++) {
            String s = Integer.toString(i);
            if (s.contains("666")) {
                movie++;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
