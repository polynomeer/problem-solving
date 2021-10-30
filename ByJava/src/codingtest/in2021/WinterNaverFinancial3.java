package codingtest.in2021;

import java.util.*;

class WinterNaverFinancial3Solution {
    private List<String> cheaters;

    void init() {
        cheaters = new ArrayList<>();
    }

    static class Student {
        String studentId;
        boolean[] isSolved = new boolean[100];
        int[] score = new int[100];
    }

    public String[] solution(String[] logs) {
        init();

        Map<String, Student> map = new HashMap<>();

        for (String log : logs) {
            String[] tokens = log.split(" ");
            String studentId = tokens[0];
            int problemNumber = Integer.parseInt(tokens[1]);
            int score = Integer.parseInt(tokens[2]);

            Student student;
            if (map.containsKey(studentId)) {
                student = map.get(studentId);
            } else {
                student = new Student();
            }

            student.studentId = studentId;
            student.isSolved[problemNumber] = true;
            student.score[problemNumber] = score;

            map.put(studentId, student);
        }

        List<Student> students = new ArrayList<>();

        for (String key : map.keySet()) {
            students.add(map.get(key));
        }

        boolean[] visited = new boolean[students.size()];

        combination(students, visited, 0, students.size(), 2);

        if (cheaters.size() == 0) {
            return new String[]{"None"};
        }

        Map<String, String> temp = new HashMap<>();
        for (String cheater : cheaters) {
            temp.put(cheater, cheater);
        }

        List<String> answer = new ArrayList<>(temp.keySet());

        answer.sort((o1, o2) -> {
            int n1 = Integer.parseInt(o1);
            int n2 = Integer.parseInt(o2);
            return Integer.compare(n1, n2);
        });

        return answer.toArray(new String[0]);
    }

    void combination(List<Student> students, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            compare(students, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(students, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    void compare(List<Student> students, boolean[] visited, int n) {
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                list.add(students.get(i));
            }
        }

        if (isMoreThanFive(list.get(0).isSolved, list.get(1).isSolved) &&
                isEqualSolved(list.get(0).isSolved, list.get(1).isSolved) &&
                isEqualScore(list.get(0).score, list.get(1).score)) {
            for (Student student : list) {
                cheaters.add(student.studentId);
            }
        }
    }

    private boolean isMoreThanFive(boolean[] isSolved1, boolean[] isSolved2) {
        int solved1 = 0;
        int solved2 = 0;

        for (int i = 0; i < isSolved1.length; i++) {
            if (isSolved1[i]) solved1++;
            if (isSolved2[i]) solved2++;
        }

        return solved1 >= 5 && solved2 >= 5;
    }

    private boolean isEqualScore(int[] score1, int[] score2) {
        for (int i = 0; i < score1.length; i++) {
            if (score1[i] != score2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isEqualSolved(boolean[] isSolved1, boolean[] isSolved2) {
        for (int i = 0; i < isSolved1.length; i++) {
            if (isSolved1[i] != isSolved2[i]) {
                return false;
            }
        }
        return true;
    }
}

public class WinterNaverFinancial3 {
    public static void main(String[] args) {
        WinterNaverFinancial3Solution sol = new WinterNaverFinancial3Solution();
        System.out.println(Arrays.toString(
                sol.solution(new String[]{"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"})));
        System.out.println(Arrays.toString(
                sol.solution(new String[]{"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"})));
        System.out.println(Arrays.toString(
                sol.solution(new String[]{"1901 10 50", "1909 10 50"})));
    }
}

/*
 * 1. 두 수험자가 푼 문제 수가 같다. 단, 푼 문제 수가 5 미만인 경우는 제외한다.
 * 2. 두 수험자가 푼 문제의 번호가 모두 같다.
 * 3. 두 수험자가 푼 문제의 점수가 모두 같다.
 *
 * 수험자의 수험번호, 문제 번호, 받은 점수
 */
