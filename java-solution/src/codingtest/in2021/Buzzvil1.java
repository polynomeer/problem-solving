package codingtest.in2021;

import util.TestUtils;

import java.util.*;

/**
 * ## 🔍 문제 요약
 * 당신의 구현은 열린 괄호는 push, 닫힌 괄호는 조건에 맞으면 pop 하도록 되어 있지만,
 * 닫힌 괄호가 짝이 맞지 않을 경우 아무 동작도 하지 않고 넘어가는 문제가 있음
 * 즉, 잘못된 괄호 쌍이어도 그냥 넘어가게 된다.
 * <p>
 * ✅ 예시로 살펴보기
 * 입력값:
 * ```text
 * {[}]}
 * ```
 * <p>
 * 분석:
 * 1. `{` → push
 * 2. `[` → push
 * 3. `}` → 이 시점에서 stack.peek()는 `[`이지만 `}`와 짝이 맞지 않음 → 아무 동작 없음 ❌ (여기서 **실패로 판단해야 함**!)
 * 4. `]` → stack.peek()는 여전히 `[` → pop됨 ✅
 * 5. `}` → stack.peek()는 `{` → pop됨 ✅
 * <p>
 * 결과적으로 `stack`은 empty 상태가 되어 `"YES"`가 반환되지만, 실제로는 순서상 잘못된 닫힘이 있었으므로 `"NO"`가 맞습니다.
 * <p>
 * ## ✅ 수정 방법
 * 닫는 괄호가 등장했을 때:
 * * 스택이 비어 있으면 → 당연히 실패
 * * 스택의 top이 매칭이 아니면 → 바로 실패 처리해야 함 (`balanced = false` 같은 flag를 둬야 함)
 * <p>
 * ## ✅ 핵심 수정 포인트
 * 짝이 맞지 않으면 바로 실패 처리 (`isBalanced = false; break;`)
 * 닫힌 괄호 처리 로직을 `else`에 묶어서 잘못된 짝을 잡아냄
 */
class BuzzvilSolution1_v1 {
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

class BuzzvilSolution1_v1_fixed {
    public static List<String> braces(List<String> values) {
        List<String> answer = new ArrayList<>();

        for (String value : values) {
            Stack<String> stack = new Stack<>();
            boolean isBalanced = true;

            for (char ch : value.toCharArray()) {
                String token = String.valueOf(ch);
                if (token.equals("[") || token.equals("{") || token.equals("(")) {
                    stack.push(token);
                } else if (token.equals("]") || token.equals("}") || token.equals(")")) {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else {
                        String top = stack.peek();
                        if (token.equals("]") && top.equals("[") ||
                                token.equals("}") && top.equals("{") ||
                                token.equals(")") && top.equals("(")) {
                            stack.pop();
                        } else {
                            isBalanced = false;
                            break;
                        }
                    }
                }
            }

            if (isBalanced && stack.isEmpty()) {
                answer.add("YES");
            } else {
                answer.add("NO");
            }
        }

        return answer;
    }
}

class BuzzvilSolution1_v2 {
    public static List<String> braces(List<String> values) {
        List<String> results = new ArrayList<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for (String s : values) {
            Stack<Character> stack = new Stack<>();
            boolean balanced = true;

            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                        balanced = false;
                        break;
                    }
                }
            }

            // Stack should be empty if balanced
            if (!stack.isEmpty()) balanced = false;

            results.add(balanced ? "YES" : "NO");
        }

        return results;
    }
}

public class Buzzvil1 {
    public static void main(String[] args) {
        List<List<String>> testCases = Arrays.asList(
                Arrays.asList("()[]{}", "{[}]}"),              // 기본 예제
                Arrays.asList("[{()}]", "[({)}]", "((()))"),   // 다양한 중첩
                Arrays.asList("", "}", "{[()]}", "{[(])}"),    // 빈 문자열, 잘못된 순서
                Arrays.asList("(", "(((((", "(()())"),         // 여는 괄호만
                Arrays.asList("([]{})", "([)]", "({[]})")      // 경계 테스트
        );

        List<List<String>> expectedResults = Arrays.asList(
                Arrays.asList("YES", "NO"),
                Arrays.asList("YES", "NO", "YES"),
                Arrays.asList("YES", "NO", "YES", "NO"),
                Arrays.asList("NO", "NO", "YES"),
                Arrays.asList("YES", "NO", "YES")
        );

        TestUtils.runBracketStringTests(BuzzvilSolution1_v2::braces, testCases, expectedResults);
    }
}
