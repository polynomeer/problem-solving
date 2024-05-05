package prgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WordClass implements Comparable<WordClass> {
    String word;
    char target;

    public WordClass(String word, char target) {
        this.word = word;
        this.target = target;
    }

    @Override
    public int compareTo(WordClass w) {
        if (this.target != w.target) {
            return this.target - w.target;
        } else {
            return this.word.compareTo(w.word);
        }
    }
}

class Solution_12915 {
    public List<String> solution(String[] strings, int n) {
        List<WordClass> stringList = new ArrayList<>();
        for (String s : strings) {
            char target = s.charAt(n);
            stringList.add(new WordClass(s, target));
        }
        Collections.sort(stringList);
        List<String> answer = new ArrayList<>();
        for (WordClass w : stringList) {
            answer.add(w.word);
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
