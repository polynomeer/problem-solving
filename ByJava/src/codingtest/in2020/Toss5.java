package codingtest.in2020;

import java.util.Arrays;
import java.util.stream.Stream;

class SolutionToss5 {
    public void solution(String s) {
        String[] input = s.split("\n");
        int[] kim = Stream.of(input[0].split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] lee = Stream.of(input[1].split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(kim));
        System.out.println(Arrays.toString(lee));

        int[] answer = new int[kim.length];
        int dept = 0;
        for (int i = 0; i < kim.length; i++) {
            int temp = kim[i] - lee[i];
            if (temp >= 0 && temp - dept >= 0) {
                answer[i] = temp - dept;
                dept = 0;
            } else {
                dept += -temp;
            }
        }

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

public class Toss5 {
    public static void main(String[] args) {
        SolutionToss5 sol = new SolutionToss5();
        sol.solution("100 300 10 0 40 0 0 70 65\n40 300 20 10 10 20 100 10 0");
    }
}
