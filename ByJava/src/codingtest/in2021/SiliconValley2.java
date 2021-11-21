package codingtest.in2021;

import java.util.*;

class SiliconValleySolution2 {

    static class Student implements Comparable<Student> {
        int grade;
        int dist;
        String name;

        public Student(int grade, int dist, String name) {
            this.grade = grade;
            this.dist = dist;
            this.name = name;
        }

        @Override
        public int compareTo(Student student) {
            if (this.grade < student.grade) {
                return 1;
            } else if (this.grade == student.grade) {
                if (this.dist < student.dist) {
                    return 1;
                } else if (this.dist == student.dist) {
                    return this.name.compareTo(student.name);
                }
            }
            return -1;
        }
    }

    public int[] solution(String[] names, int[][] homes, double[] grades) {
        int[] answer = new int[names.length];

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int dist = homes[i][0] * homes[i][0] + homes[i][1] * homes[i][1];
            students.add(new Student((int) grades[i], dist, names[i]));
        }

        Collections.sort(students);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < students.size(); i++) {
            map.put(students.get(i).name, i + 1);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(names[i]);
        }

        return answer;
    }
}

public class SiliconValley2 {
    public static void main(String[] args) {
        SiliconValleySolution2 sol = new SiliconValleySolution2();
        System.out.println(Arrays.toString(sol.solution(
                new String[]{"azad", "andy", "louis", "will", "edward"},
                new int[][]{{3, 4}, {-1, 5}, {-4, 4}, {3, 4}, {-5, 0}},
                new double[]{4.19, 3.77, 4.41, 3.65, 3.58}
        )));
        System.out.println(Arrays.toString(sol.solution(
                new String[]{"clanguage", "csharp", "java", "python"},
                new int[][]{{3, -3}, {-2, 7}, {-1, -1}, {5, 4}},
                new double[]{1.27, 4.31, 4.26, 3.99}
        )));
        System.out.println(Arrays.toString(sol.solution(
                new String[]{"zzzzzzzzzz"},
                new int[][]{{9999, -9999}},
                new double[]{1.0}
        )));
    }
}
