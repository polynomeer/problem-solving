package codingtest.in2021;

import java.util.*;

class Line1Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int[] scores = new int[table.length];

        for (int l = 0; l < languages.length; l++) {
            int index = 0;
            for (String t : table) {
                int score = 0;
                String[] data = t.split(" ");
                Map<String, Integer> map = new HashMap<>();

                for (int i = 1; i < data.length; i++) {
                    map.put(data[i], data.length - i);
                }

                int scoreByGroup = map.getOrDefault(languages[l], 0);
                score = scoreByGroup * preference[l];
//                System.out.println(preference[l] + " * " + scoreByGroup + " = " + score);
                scores[index] += score;
                index++;
            }
        }

        int maxScore = -987654321;
        for (int score : scores) {
            maxScore = Math.max(maxScore, score);
        }

        int answerIndex = 0;
        List<String> answerCandi = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                String column = table[i].split(" ")[0];
                answerCandi.add(column);
            }
        }

        Collections.sort(answerCandi);
        answer = answerCandi.get(0);

        return answer;
    }
}

public class Line1 {
    private static final String[] TABLE = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};

    public static void main(String[] args) {
        Line1Solution sol = new Line1Solution();
        System.out.println(sol.solution(TABLE, new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
    }
}
