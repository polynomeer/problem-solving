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


class BuzzvilResult2 {

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

public class Buzzvil2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = BuzzvilResult2.programmerStrings(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
