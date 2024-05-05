package codingtest.in2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Line3Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = {};

        for (int i = 0; i < leave.length; i++) {
            List<Integer> precede = new ArrayList<>();
            for (int j = enter.length -1; j >=0; j--) {
                if (leave[i] == enter[j]) {

                }

            }

        }
        return answer;
    }
}

public class Line3 {
    public static void main(String[] args) {
        Line3Solution sol = new Line3Solution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 3, 2}, new int[]{1, 2, 3})));
    }
}
