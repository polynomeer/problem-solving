package boj;

import java.util.Scanner;

public class BaekJoon14501 {
    static int N, answer;
    static int[] T, P;

    private static void consult(int day, int sum) {
        if (day == N + 1) { // 퇴사
            answer = Math.max(answer, sum);
            return;
        }
        if (day > N + 1) { // 이미 퇴사
            return;
        }
        consult(day + 1, sum); // 상담 x
        consult(day + T[day], sum + P[day]); // 상담 o
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N + 2];
        P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        consult(1, 0);
        System.out.println(answer);
    }
}
