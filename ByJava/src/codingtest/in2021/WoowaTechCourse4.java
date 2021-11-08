package codingtest.in2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class WoowaTechCourse4Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        char[] chars = s.toCharArray();

        int consequence = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                answer.add(consequence);
                consequence = 1;
            } else {
                consequence++;
            }
        }
        answer.add(consequence);

        if (chars[0] == chars[chars.length - 1]) {
            int lastConsequence = answer.get(answer.size() - 1);
            answer.remove(answer.size() - 1);
            answer.set(0, answer.get(0) + lastConsequence);
        }

        Collections.sort(answer);

        return answer;
    }
}

public class WoowaTechCourse4 {
    public static void main(String[] args) {
        WoowaTechCourse4Solution sol = new WoowaTechCourse4Solution();
        System.out.println(sol.solution("aaabbaaa"));
        System.out.println(sol.solution("wowwow"));
        System.out.println(sol.solution("aaabbbbcccccdddeeea"));
//        System.out.println(Arrays.toString(sol.solution("aaabbaaa")));
//        System.out.println(Arrays.toString(sol.solution("wowwow")));
    }
}
