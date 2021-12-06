package codingtest.in2021;

import java.util.Arrays;

class TodayHouseSolution2 {
    public long[] solution(long n) {
        long[] answer = new long[2];
        answer[0] = answer[1] = -1;

        for (int i = 2; i < n; i++) {
            if (n % i == 0 && i != n / i) {
                if (isPrime(i) && isPrime(n / i)) {
                    answer[0] = i;
                    answer[1] = n / i;
                    break;
                }
            }
        }
        return answer;
    }

    boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class TodayHouse2 {
    public static void main(String[] args) {
        TodayHouseSolution2 sol = new TodayHouseSolution2();
        System.out.println(Arrays.toString(sol.solution(6)));
        System.out.println(Arrays.toString(sol.solution(12)));
        System.out.println(Arrays.toString(sol.solution(9)));
        System.out.println(Arrays.toString(sol.solution(14)));
        System.out.println(Arrays.toString(sol.solution(21)));
    }
}
