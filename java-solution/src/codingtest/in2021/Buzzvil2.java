package codingtest.in2021;

import util.TestUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BuzzvilSolution2_v1 {

    public static int programmerStrings(String s) {
        Map<String, Integer> programmerMap = new HashMap<>();
        String programmerStr = "programmer";
        String[] tokens = programmerStr.split("");

        for (String token : tokens) {
            programmerMap.put(token, programmerMap.getOrDefault(token, 0) + 1);
        }

        String[] strings = s.split("");
        Map<String, Integer> map = new HashMap<>();
        int left = 0;

        for (; left < strings.length; left++) {
            map.put(strings[left], map.getOrDefault(strings[left], 0) + 1);
            if (isProgrammer(programmerMap, map)) break;
        }

        int right = strings.length - 1;
        map = new HashMap<>();

        for (; right >= 0; right--) {
            map.put(strings[right], map.getOrDefault(strings[right], 0) + 1);
            if (isProgrammer(programmerMap, map)) break;
        }

        return right - left - 1;
    }

    private static boolean isProgrammer(Map<String, Integer> programmerMap, Map<String, Integer> map) {
        for (String key : programmerMap.keySet()) {
            if (map.getOrDefault(key, 0) < programmerMap.get(key)) {
                return false;
            }
        }
        return true;
    }

}

class BuzzvilSolution2 {

    public static int programmerStrings(String s) {
        String target = "programmer";
        Map<Character, Integer> targetCount = getCharCount(target);

        int n = s.length();
        int leftEnd = -1;
        Map<Character, Integer> leftCount = new HashMap<>();

        // 찾기: 왼쪽부터 가장 먼저 나오는 programmer 문자열
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            leftCount.put(c, leftCount.getOrDefault(c, 0) + 1);

            if (isComplete(leftCount, targetCount)) {
                leftEnd = i;
                break;
            }
        }

        // 찾기: 오른쪽부터 가장 먼저 나오는 programmer 문자열
        int rightStart = -1;
        Map<Character, Integer> rightCount = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            rightCount.put(c, rightCount.getOrDefault(c, 0) + 1);

            if (isComplete(rightCount, targetCount)) {
                rightStart = i;
                break;
            }
        }

        return rightStart - leftEnd - 1;
    }

    private static Map<Character, Integer> getCharCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private static boolean isComplete(Map<Character, Integer> current, Map<Character, Integer> target) {
        for (char c : target.keySet()) {
            if (current.getOrDefault(c, 0) < target.get(c)) {
                return false;
            }
        }
        return true;
    }
}

public class Buzzvil2 {
    public static void main(String[] args) {
        List<String> testCases = Arrays.asList(
                "progxrammerrxproxgrammer",    // 2
                "xprogxrmaxemrppprmmograeiruu",// 2
                "programmerprogrammer",        // 0
                "programmerxxxprozmerqgram",   // 3
                "xprogrammerxprogrammerx"      // 1
        );

        List<Integer> expected = Arrays.asList(2, 2, 0, 3, 1);

        TestUtils.runProgrammerStringTests(BuzzvilSolution2::programmerStrings, testCases, expected);
    }
}

