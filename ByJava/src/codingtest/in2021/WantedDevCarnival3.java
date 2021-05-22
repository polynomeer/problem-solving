package codingtest.in2021;

import java.util.Scanner;

class WantedDevCarnival3Solution {
    int count = 0;

    void solution(int n, int k) {
        count = 0;
        for (int i = k; i <= 7; i++) {
            combination(0, 7, i);
            System.out.println(count);
        }
        long answer = (long) (Math.pow(2, n) - (long) ((n - 7) + 1) * count);
        answer = answer % (long) (Math.pow(10, 9) + 7);
        System.out.println(answer);
    }

    void combination(int start, int n, int r) {
        if (r == 0) {
            count++;
            return;
        }

        for (int i = start; i < n; i++) {
            combination(i + 1, n, r - 1);
        }
    }

}

public class WantedDevCarnival3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WantedDevCarnival3Solution sol = new WantedDevCarnival3Solution();

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        sol.solution(n, k);


//        sol.solution(10, 4);
//        System.out.println("answer : " + 322);
//        sol.solution(8, 2);
//        System.out.println("answer : " + 10);
//        sol.solution(9, 3);
//        System.out.println("answer : " + 66);
    }
}
