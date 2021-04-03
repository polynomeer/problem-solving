package codingtest.in2021;

import java.util.*;

class KakaoMakers2Solution {
    public int solution(int[][] needs, int r) {
        int answer = 0;
        Map<Integer, Integer> parts = new HashMap<>(needs.length);

        for (int[] need : needs) {
            for (int j = 0; j < need.length; j++) {
                int neededPart = need[j];
                if (neededPart == 1) {
                    parts.put(j, parts.getOrDefault(j, 0) + 1);
                }
            }
        }

        Map<Integer, Integer> sortedParts = sortMapByValue(parts);
        Set<Integer> robots = new HashSet<>();

        int index = 0;
        for (Integer key : sortedParts.keySet()) {
            if (sortedParts.size() - index == r) {
                robots.add(key);
                r--;
                System.out.printf("키 : %s, 값 : %s%n", key, sortedParts.get(key));
            }
            index++;
        }

        for (int i = 0; i < needs.length; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < needs[i].length; j++) {
                if (needs[i][j] == 1) {
                    s.push(j);
                    if (robots.contains(j)) {
                        s.pop();
                    }
                }
            }

            if (s.size() == 0) {
                answer++;
            }
        }
        return answer;
    }

    public LinkedHashMap<Integer, Integer> sortMapByValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}

public class KakaoMakers2 {
    public static void main(String[] args) {
        KakaoMakers2Solution sol = new KakaoMakers2Solution();
        int[][] test = new int[][]{
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(sol.solution(test, 2));
    }
}
