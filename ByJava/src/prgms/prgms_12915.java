package prgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Strings implements Comparable<Strings> {
    String word;
    char target;

    public Strings(String word, char target) {
        this.word = word;
        this.target = target;
    }

    public int compareTo(Strings s) {
        if (this.target != s.target) {
            return this.target - s.target;
        } else {
            return this.word.compareTo(s.word);
        }
    }
}

class Solution_12915 {
    public List<String> solution(String[] strings, int n) {
        List<Strings> stringList = new ArrayList<>();
        for (String s : strings) {
            char target = s.charAt(n);
            stringList.add(new Strings(s, target));
        }
        Collections.sort(stringList);
        List<String> answer = new ArrayList<>();
        for (Strings s : stringList) {
            answer.add(s.word);
        }
        return answer;
    }
}

public class prgms_12915 {
    public static void main(String[] args) {
        Solution_12915 sol = new Solution_12915();
        System.out.println(sol.solution(new String[]{"sun", "bed", "car"}, 1));
        System.out.println(sol.solution(new String[]{"abce", "abcd", "cdx"}, 2));
    }
}
