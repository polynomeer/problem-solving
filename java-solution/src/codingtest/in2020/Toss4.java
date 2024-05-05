package codingtest.in2020;

import java.util.*;

class SolutionToss4 {
    public void solution(String s) {
        Set<String> lastUsedSet = new LinkedHashSet<>();
        String[] tokens = s.split(" ");

        for (String token : tokens) {
            lastUsedSet.remove(token);
            lastUsedSet.add(token);

            if (!lastUsedSet.isEmpty()) {
                LinkedList<String> list = new LinkedList<>(lastUsedSet);
                Iterator<String> iter = list.descendingIterator();
                int count = 0;

                while (iter.hasNext()) {
                    if (count >= 5) break;
                    String item = iter.next();
                    System.out.print(item + " ");
                    count++;
                }
                System.out.println();
            }
        }
    }
}

public class Toss4 {
    public static void main(String[] args) {
        SolutionToss4 sol = new SolutionToss4();
        sol.solution("우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축");
    }
}
