package codingtest.in2020;

import java.util.Arrays;

class PrgmsWinterCoding1Solution {
    public String solution(int n, int[][] deliveryList) {
        char[] result = new char[n];
        Arrays.fill(result, '?');

        while(n > 0){
            for (int[] delivery : deliveryList) {
                if (delivery[2] == 1) {
                    result[delivery[0] - 1] = 'O';
                    result[delivery[1] - 1] = 'O';
                } else {
                    if (result[delivery[0] - 1] == 'O') result[delivery[1] - 1] = 'X';
                    else if (result[delivery[1] - 1] == 'O') result[delivery[0] - 1] = 'X';

                }
            }
            n--;
        }
        return String.valueOf(result);
    }
}

public class PrgmsWinterCoding1 {
    public static void main(String[] args) {
        PrgmsWinterCoding1Solution sol = new PrgmsWinterCoding1Solution();
        System.out.println(sol.solution(6, new int[][]{{1, 3, 1}, {3, 5, 0}, {5, 4, 0}, {2, 5, 0}}));
        System.out.println(sol.solution(7, new int[][]{{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}}));
    }
}
