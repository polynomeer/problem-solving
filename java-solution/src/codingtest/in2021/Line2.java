package codingtest.in2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Line2Solution {
    public List<Integer> solution(String password) {
        List<Integer> answer = new ArrayList<>();

        // step 1
        if (password.length() < 8 || password.length() > 15) {
            answer.add(1);
        }

        // step 2
        String newPassword = password.replaceAll("[^A-Za-z0-9~!@#$%^&*]", "");
        if (!password.equals(newPassword)) {
            answer.add(2);
        }

        // step 3
        int count = 0;

        newPassword = password.replaceAll("[A-Z]", "");
        if (!password.equals(newPassword)) count++;
        newPassword = password.replaceAll("[a-z]", "");
        if (!password.equals(newPassword)) count++;
        newPassword = password.replaceAll("[0-9]", "");
        if (!password.equals(newPassword)) count++;
        newPassword = password.replaceAll("[~!@#$%^&*]", "");
        if (!password.equals(newPassword)) count++;
        if (count < 3) answer.add(3);

        // step 4
        char[] c = password.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            int cnt = 0;
            if (c[i] == c[i + 1]) {
                cnt++;
                for (; i < c.length - 1; i++) {
                    char c1 = c[i];
                    if (c[i] == c[i + 1]) {
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
            if (cnt >= 4) {
                answer.add(4);
                break;
            }
        }

        // step 5
        Map<String, Integer> map = new HashMap<>();
        String[] strings = password.split("");
        for (String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value >= 5) {
                answer.add(5);
            }

        }

        if (answer.size() == 0) {
            answer.add(0);
        }

        return answer;
    }
}

public class Line2 {
    public static void main(String[] args) {
        Line2Solution sol = new Line2Solution();
        System.out.println((sol.solution("AaTa+!12-3")));
        System.out.println((sol.solution("aaaaZZZZ)")));
        System.out.println((sol.solution("CaCbCgCdC888834A")));
        System.out.println((sol.solution("UUUUU")));
        System.out.println((sol.solution("ZzZz9Z824")));
        System.out.println((sol.solution("~!@#$%^&*")));
        System.out.println((sol.solution("Aaa12ZZZZ")));
    }
}
