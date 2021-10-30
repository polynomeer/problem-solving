package codingtest.in2021;

import java.util.HashMap;
import java.util.Map;

class WinterNaverFinancial1Solution {
    public int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String id : id_list) {
            String[] tokens = id.split(" ");
            Map<String, Integer> temp = new HashMap<>();

            for (String token : tokens) {
                temp.put(token, 0);
            }

            for (String key : temp.keySet()) {
                map.put(key, Math.min(map.getOrDefault(key, 0) + 1, k));
            }
        }

        for (String key : map.keySet()) {
            answer += map.get(key);
        }

        return answer;
    }
}

public class WinterNaverFinancial1 {
    public static void main(String[] args) {
        WinterNaverFinancial1Solution sol = new WinterNaverFinancial1Solution();
        System.out.println(sol.solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2));
        System.out.println(sol.solution(new String[]{"A B C D", "A D", "A B D", "B D"}, 2) == 7);
        System.out.println(sol.solution(new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3));
        System.out.println(sol.solution(new String[]{"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"}, 3) == 8);
    }
}
