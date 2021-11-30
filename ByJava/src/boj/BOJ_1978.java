package boj;

import java.util.Scanner;

public class BOJ_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            if (isPrime(number)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
