package codingtest.in2021;

import java.util.Scanner;

class WantedDevCarnival1Solution {
    void solution(int n, int k, int[] foods) {
        while (n > 0) {
            for (int i = k - 1; i < foods.length; i++) {
                if (foods[i] > 0) {
                    foods[i]--;
                    if (foods[i] == 0) {
                        n--;
                        System.out.print((i + 1) + " ");
                    }
                }
            }

            for (int i = 0; i < k - 1; i++) {
                if (foods[i] > 0) {
                    foods[i]--;
                    if (foods[i] == 0) {
                        n--;
                        System.out.print((i + 1) + " ");
                    }
                }
            }
        }
    }
}

public class WantedDevCarnival1 {
    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        int[] foods = new int[n];
//        for (int i = 0; i < foods.length; i++) {
//            foods[i] = scanner.nextInt();
//        }

        WantedDevCarnival1Solution sol = new WantedDevCarnival1Solution();
//        sol.solution(n, k, foods);
        sol.solution(4, 3, new int[]{8, 6, 7, 1});
        System.out.println();
        sol.solution(5, 2, new int[]{1, 7, 2, 1, 3});
        System.out.println();
        sol.solution(7, 7, new int[]{6, 1, 4, 4, 8, 7, 7});
        System.out.println();
    }
}
