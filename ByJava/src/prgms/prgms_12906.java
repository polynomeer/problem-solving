package prgms;

import java.util.*;

class Solution_12906 {
    public List<Integer> solution(int[] arr) {
        if (arr.length == 0) return null;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                answer.add(arr[i]);
            }
        }
        if (answer.size() == 0){
            answer.add(arr[0]);
            return answer;
        }
        if (answer.get(answer.size() - 1) != arr[arr.length - 1]) {
            answer.add(arr[arr.length - 1]);
        }
        return answer;
    }
}

public class prgms_12906 {
    public static void main(String[] args) {
        Solution_12906 sol = new Solution_12906();
        System.out.println(sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1}));
        System.out.println(sol.solution(new int[]{4, 4, 4, 3, 3}));
        System.out.println(sol.solution(new int[]{}));
        System.out.println(sol.solution(new int[]{1, 1, 1}));
    }
}
