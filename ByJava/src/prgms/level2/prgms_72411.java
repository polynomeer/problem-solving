package prgms.level2;

import java.util.*;

class Solution_72411 {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String order : orders) {
            for (String o : orders) {
                if (isContain(order, o)) {
                    map.put(order, map.getOrDefault(order, 0) + 1);
                }
            }
        }

        for (String key : map.keySet()) {
            System.out.println("key = " + key + ", value = " + map.get(key));
            if (isCourse(map.get(key), course)) {
                answer.add(key);
            }
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private boolean isCourse(int value, int[] course) {
        for (int c : course) {
            if (value == c) return true;
        }
        return false;
    }

    private boolean isContain(String target, String input) {
        String[] strings = target.split("");
        for (String string : strings) {
            if (!input.contains(string)) return false;
        }
        return true;
    }
}

public class prgms_72411 {
    public static void main(String[] args) {
        Solution_72411 sol = new Solution_72411();
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(sol.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}
