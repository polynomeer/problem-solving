package codingtest.in2021;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


import java.util.*;

class BuzzvilSolution4 {

    public static String largestMagical(String binString) {
        List<String> goodSubstrings = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < binString.length(); i++) {
            if (binString.charAt(i) == '1') balance++;
            else balance--;

            if (balance == 0) {
                // 현재 구간은 good binary string
                String inner = binString.substring(start + 1, i); // 내부 부분 재귀 처리
                String largestInner = largestMagical(inner);      // 재귀 호출
                goodSubstrings.add("1" + largestInner + "0");     // 포장
                start = i + 1;
            }
        }

        // 사전순으로 내림차순 정렬
        goodSubstrings.sort(Comparator.reverseOrder());

        // 정렬된 good substring 합치기
        return String.join("", goodSubstrings);
    }
}


public class Buzzvil4 {
    public static void main(String[] args) {
        runTest("1100", "1100");
        runTest("11011000", "11100100");
        runTest("1101001100", "1101001100");
        runTest("1010", "1010");
        runTest("111000", "111000");
    }

    private static void runTest(String input, String expected) {
        String result = BuzzvilSolution4.largestMagical(input);
        boolean passed = result.equals(expected);
        System.out.printf("Test %s\n", passed ? "PASSED" : "FAILED");
        System.out.println("Input:    " + input);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println();
    }
}
