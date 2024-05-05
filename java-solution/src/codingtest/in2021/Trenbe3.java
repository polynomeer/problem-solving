package codingtest.in2021;

import java.util.HashMap;
import java.util.Map;

class TrenbeSolution3 {

    public int solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                min = Math.min(min, i - map.get(arr[i]));
            }
            map.put(arr[i], i);
        }

        if (min != Integer.MAX_VALUE) return min;
        else return -1;
    }
}

public class Trenbe3 {
    public static void main(String[] args) {
        TrenbeSolution3 sol = new TrenbeSolution3();
        System.out.println(sol.solution(new int[]{2, 1, 3, 1, 4, 2, 1, 3}) == 2);
        System.out.println(sol.solution(new int[]{1, 2, 3}) == -1);
    }

}
