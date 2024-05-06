package prgms;

import java.util.HashMap;
import java.util.Map;

class Solution42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            if (!map.containsKey(clothe[1])) {
                map.put(clothe[1], 1);
            } else {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            }
        }

        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }
}


public class Programmers42578 {
    public static void main(String[] args) {
        Solution42578 sol = new Solution42578();
        System.out.println(sol.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(sol.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
