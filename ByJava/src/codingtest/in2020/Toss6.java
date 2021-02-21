package codingtest.in2020;

import java.util.ArrayList;
import java.util.List;

class SolutionToss6 {
    int[] dx = {-1, 1, 0, 0,};
    int[] dy = {0, 0, -1, 1};

    int solution(String s) {
        String[] row = s.split(";");
        List<String[]> list = new ArrayList<>();
        for (String r : row) {
            String[] space = r.split(" ");
            list.add(space);
        }
        for (String[] r : list) {
            for (String cell : r) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                if (list.get(i)[j].equals("1")) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < list.size() && ny >= 0 && ny < list.get(i).length) {
                            if (list.get(i + dx[k])[j + dy[k]].equals("0")) {
                                answer++;
                            }
                        }
                    }
                }
            }

        }
        return answer;
    }
}

public class Toss6 {
    public static void main(String[] args) {
        SolutionToss6 sol = new SolutionToss6();
        System.out.println(sol.solution("0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0"));
        System.out.println(sol.solution("0 0 0 0 0;0 1 1 1 0;0 1 0 1 0;0 1 1 1 0;0 0 0 0 0"));
        System.out.println(sol.solution("0 0 0;0 1 0;0 0 0"));
    }
}
