package codingtest.in2021;

import java.util.Arrays;
import java.util.Comparator;

class TrenbeSolution1 {
    public int solution(int N) {
        int answer = 0;
        String[] tokens = getStrArray(N);

        Arrays.sort(tokens);
        String ascending = extractStr(tokens);
        Arrays.sort(tokens, Comparator.reverseOrder());
        String descending = extractStr(tokens);
        answer = Integer.parseInt(ascending) + Integer.parseInt(descending);
        return answer;
    }

    private String extractStr(String[] tokens) {
        StringBuilder builder = new StringBuilder();
        for (String token : tokens) {
            builder.append(token);
        }
        return builder.toString();
    }

    private String[] getStrArray(int n) {
        String str = Integer.toString(n);
        return str.split("");
    }
}

public class Trenbe1 {
    public static void main(String[] args) {
        TrenbeSolution1 sol = new TrenbeSolution1();
        System.out.println(sol.solution(2613) == 7557);
        System.out.println(sol.solution(33285) == 108690);
    }
}
