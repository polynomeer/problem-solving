package util;

import java.util.*;
import java.util.function.Function;

public class TestUtils {

    // 기존: 단일 문자열 → 정수 반환
    public static void runProgrammerStringTests(Function<String, Integer> functionToTest,
                                                List<String> testCases,
                                                List<Integer> expectedResults) {
        int totalPassed = 0;

        for (int i = 0; i < testCases.size(); i++) {
            String input = testCases.get(i);
            int expected = expectedResults.get(i);
            int actual = functionToTest.apply(input);

            boolean passed = actual == expected;
            if (passed) totalPassed++;

            System.out.printf("Test Case %d: %s\n", i + 1, passed ? "PASSED" : "FAILED");
            System.out.println("Input:    " + input);
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
            System.out.println();
        }

        System.out.printf("Total Passed: %d / %d\n", totalPassed, testCases.size());
    }

    // 추가: 리스트 → 리스트 테스트용
    public static void runBracketStringTests(Function<List<String>, List<String>> functionToTest,
                                             List<List<String>> testCases,
                                             List<List<String>> expectedResults) {
        int totalPassed = 0;

        for (int i = 0; i < testCases.size(); i++) {
            List<String> input = testCases.get(i);
            List<String> expected = expectedResults.get(i);
            List<String> actual = functionToTest.apply(input);

            boolean passed = actual.equals(expected);
            if (passed) totalPassed++;

            System.out.printf("Test Case %d: %s\n", i + 1, passed ? "PASSED" : "FAILED");
            System.out.println("Input:    " + input);
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
            System.out.println();
        }

        System.out.printf("Total Passed: %d / %d\n", totalPassed, testCases.size());
    }
}
