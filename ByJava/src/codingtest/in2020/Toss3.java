package codingtest.in2020;

import java.util.HashMap;
import java.util.Map;

class SolutionToss3 {
    private int count = 0;

    private int[] toIntArray(String s) {
        String[] tokens = s.split(" ");
        int[] numbers = new int[tokens.length];
        int i = 0;
        for (String token : tokens) {
            numbers[i++] = Integer.parseInt(token);
        }
        return numbers;
    }

    public String solution(String s) {
        count = 0;
        String answer = "";
        int[] numbers = toIntArray(s);
        Map<Integer,Integer> map = new HashMap<>();

        for (int number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, compute(number));
            }
        }

        int[] answerArray = new int[numbers.length];
        int i = 0;
        for (int number : numbers) {
            int value = map.get(number);
            answerArray[i++] = value;
        }
        answer = toString(answerArray);

        System.out.println(count + " seconds");
        return answer;
    }

    public String toString(int[] numbers){
        StringBuilder sb = new StringBuilder();
        for (int number : numbers){
            sb.append(number).append(" ");
        }
        return sb.toString().trim();
    }

    private int compute(int n) {
        int[] table = new int[]{2220, 9708, 8420, 41600, 7915, 51200, 58212};
        count++;
        return table[n];
    }
}

public class Toss3 {
    public static void main(String[] args) {
        SolutionToss3 sol = new SolutionToss3();
        System.out.println(sol.solution("1 1 3 4 3 6 3").equals("9708 9708 41600 7915 41600 58212 41600"));
    }
}
