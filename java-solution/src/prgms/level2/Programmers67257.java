package prgms.level2;

import java.util.Arrays;
import java.util.List;

class Solution67257 {
    public long solution(String expression) {
        long answer = 0;
        List<Long> numbers = Arrays.stream(expression.split("[-+*]")).map(Long::parseLong).toList();
        List<String> operators = Arrays.stream(expression.replaceAll("[^-+*]", "").split("")).toList();

        for (int i = 0; i < numbers.size(); i++) {
            if (operators.get(i).equals("+")) {
                long result = calculate(numbers.get(i), numbers.get(i + 1), operators.get(i));
                numbers.add(i, result);
            }
        }

        for (Long number : numbers) {
            System.out.println(number);
        }

        return answer;
    }

    static long calculate(long number1, long number2, String operator) {
        return switch (operator) {
            case "-" -> number1 - number2;
            case "+" -> number1 + number2;
            case "*" -> number1 * number2;
            default -> throw new IllegalArgumentException("Input value " + operator + "is not operator.");
        };
    }
}

public class Programmers67257 {
    public static void main(String[] args) {
        Solution67257 sol = new Solution67257();
        System.out.println(sol.solution("100-200*300-500+20") == 60420);
        System.out.println(sol.solution("50*6-3*2") == 300);
    }
}
