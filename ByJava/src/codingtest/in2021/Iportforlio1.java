package codingtest.in2021;

import java.util.Arrays;

class IportforlioSolution1 {
    public int solution(int n) {
        boolean[] doors = new boolean[n + 1];
        int answer = 0;

        Arrays.fill(doors, true);

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                doors[i] = i % 3 == 0;
            } else {
                if (i % 3 == 0) doors[i] = !doors[i];
            }
        }

        for (int i = 1; i < doors.length; i++) {
            if (doors[i]) answer++;
        }

        return answer;
    }
}

public class Iportforlio1 {
    public static void main(String[] args) {
        IportforlioSolution1 sol = new IportforlioSolution1();
        System.out.println(sol.solution(2));
        System.out.println(sol.solution(5));
    }
}
