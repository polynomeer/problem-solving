package codingtest.in2021;

import java.util.*;

class DevMatching1Solution {
    public String solution(String[] registered_list, String new_id) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String r : registered_list) {
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        while (true) {
            if (map.containsKey(new_id)) {
                StringBuilder S = new StringBuilder();
                StringBuilder N = new StringBuilder();
                char[] chars = new_id.toCharArray();

                for (char c : chars) {
                    if (c >= '0' && c <= '9') {
                        N.append(c);
                    } else {
                        S.append(c);
                    }
                }

                String string = S.toString();
                String number = N.toString();
                int n = number.equals("") ? 0 : Integer.parseInt(number);

                new_id = string + Integer.toString(n + 1);
            } else {
                answer = new_id;
                break;
            }
        }

        return answer;
    }
}

public class DevMatching1 {
    public static void main(String[] args) {
        DevMatching1Solution sol = new DevMatching1Solution();

    }
}
