package codingtest.in2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class TodayHouseSolution1 {
    public int solution(int n, int m, int[] points, String[] hands) {
        int[] scores = new int[n];
        int baseScore = 0;

        for (int round = 0; round < m; round++) {
            Map<String, Integer> map = new HashMap<>();
            String[] players = hands[round].split("");

            for (String player : players) {
                map.put(player, map.getOrDefault(player, 0) + 1);
            }

            String winner;
            if (map.size() == 1) {
                baseScore = points[round];
            } else if (map.size() == 2) {
                winner = go(map.keySet());
                if (points[round] >= 0) {
                    for (int i = 0; i < players.length; i++) {
                        if (players[i].equals(winner)) {
                            scores[i] += points[round] + baseScore;
                        }
                    }
                } else {
                    for (int i = 0; i < players.length; i++) {
                        if (!players[i].equals(winner)) {
                            scores[i] += points[round] + baseScore;
                        }
                    }
                }
                baseScore = 0;
            } else if (map.size() == 3) {
                if (map.get("P").equals(map.get("R")) && map.get("S").equals(map.get("P"))) {
                    continue;
                } else if (map.get("P").equals(map.get("R"))) {
                    for (int i = 0; i < players.length; i++) {
                        if (players[i].equals("S")) {
                            scores[i] += points[round] + baseScore;
                        }
                    }
                } else if (map.get("R").equals(map.get("S"))) {
                    for (int i = 0; i < players.length; i++) {
                        if (players[i].equals("P")) {
                            scores[i] += points[round] + baseScore;
                        }
                    }
                } else if (map.get("S").equals(map.get("P"))) {
                    for (int i = 0; i < players.length; i++) {
                        if (players[i].equals("R")) {
                            scores[i] += points[round] + baseScore;
                        }
                    }
                } else if (!map.get("P").equals(map.get("R")) && !map.get("S").equals(map.get("P"))) {
                    if (points[round] >= 0) {

                    }
                }

                baseScore = 0;
            }
        }

        System.out.println("scores = " + Arrays.toString(scores));
        Arrays.sort(scores);
        return scores[n - 1];
    }

    private String go(Set<String> keySet) {
        StringBuilder result = new StringBuilder();

        for (String key : keySet) {
            result.append(key);
        }

        String r = result.toString();

        switch (r) {
            case "PR":
            case "RP":
                return "P";
            case "RS":
            case "SR":
                return "R";
            case "PS":
            case "SP":
                return "S";
        }

        return "N";
    }

}

public class TodayHouse1 {
    public static void main(String[] args) {
        TodayHouseSolution1 sol = new TodayHouseSolution1();
        System.out.println(sol.solution(6, 5, new int[]{5, -2, 1, 3, -5}, new String[]{"PSPRSS", "SSRRSS", "RRRRRR", "RRSSPP", "SSSRRP"}) == 4);
    }
}
