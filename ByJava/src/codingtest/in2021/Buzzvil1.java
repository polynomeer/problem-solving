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


class Result {
    public static List<String> braces(List<String> values) {
        List<String> answer = new ArrayList<>();

        for (String value : values) {
            String[] tokens = value.split("");
            Stack<String> stack = new Stack<>();

            for (String token : tokens) {
                if (token.equals("[") || token.equals("{") || token.equals("(")) {
                    stack.push(token);
                }
                if ((token.equals("]") || token.equals("}") || token.equals(")"))) {
                    if (stack.size() == 0) {
                        stack.push("");
                        break;
                    } else if (token.equals("]") && stack.peek().equals("[")
                            || token.equals("}") && stack.peek().equals("{")
                            || token.equals(")") && stack.peek().equals("(")) {
                        stack.pop();
                    }
                }
            }
            if (stack.size() == 0) answer.add("YES");
            else answer.add("NO");
        }
        return answer;
    }
}

public class Buzzvil1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> values = IntStream.range(0, valuesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.braces(values);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
