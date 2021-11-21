package codingtest.in2021;

import java.util.*;

class Kakao2Solutuion {

    public int solution(int n, int k) {
        int answer = 0;
        String converted = convert(n, k);
        Stack<Character> stack = new Stack<>();
        char[] num = converted.toCharArray();
        String temp = "";
        boolean isFirst = true;
        System.out.println("converted = " + converted);
        for (int i = 0; i < num.length; i++) {
            if (num[i] == '0') {
                if (stack.isEmpty()) {
                    if (isFirst) { // P0 case
                        String convertedTemp = convert(Long.parseLong(temp), 10);
                        if (!convertedTemp.equals("")) {
                            if (isPrime(Long.parseLong(convertedTemp))) { // 0P0 case
                                System.out.println("temp = " + temp);
                                answer++;
                            }
                        }
                        isFirst = false;
                    }
                    stack.push(num[i]);
                } else if (num[i - 1] != '0') {
                    String convertedTemp = convert(Long.parseLong(temp), 10);
                    if (!convertedTemp.equals("")) {
                        if (isPrime(Long.parseLong(convertedTemp))) { // 0P0 case
                            System.out.println("temp = " + temp);
                            answer++;
                        }
                    }
                    temp = "";
                    stack.pop();
                }
            }
            temp = temp + num[i];
        }
        if (!isFirst && temp.toCharArray()[0] == '0' && isPrime(Long.parseLong(convert(Integer.parseInt(temp), 10)))) {
            System.out.println("temp = " + temp);
            answer++;
        }

        return answer;
    }

    private String convert(long n, int k) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, (n % k));
            n /= k;
        }
        return result.toString();
    }

    private boolean isPrime(long num) {
        if (num <= 1) return false;
        boolean result = true;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

}

class Kakao2Solutuion2 {
    // 정규표현식...
    public int solution(int n, int k) {
        int answer = 0;
        String converted = convert(n, k);
        Stack<Character> stack = new Stack<>();
        char[] num = converted.toCharArray();
        String temp = "";
        boolean isFirst = true;


        return answer;
    }

    private String convert(long n, int k) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.insert(0, (n % k));
            n /= k;
        }
        return result.toString();
    }

    private boolean isPrime(long num) {
        if (num <= 1) return false;
        boolean result = true;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

}

public class Kakao2 {
    public static void main(String[] args) {
        Kakao2Solutuion kakao2Solutuion = new Kakao2Solutuion();
        System.out.println("kakao2Solutuion.solution(437674, 3) = " + kakao2Solutuion.solution(437674, 3));
        System.out.println("kakao2Solutuion.solution(110011, 10) = " + kakao2Solutuion.solution(110011, 10));
        System.out.println("kakao2Solutuion.solution(43584203, 2) = " + kakao2Solutuion.solution(43584203, 2));
        System.out.println("kakao2Solutuion.solution(6844323, 4) = " + kakao2Solutuion.solution(6844323, 4));
        System.out.println("kakao2Solutuion.solution(7634542223, 5) = " + kakao2Solutuion.solution(763442223, 5));
        System.out.println("kakao2Solutuion.solution(643325633, 7) = " + kakao2Solutuion.solution(643125623, 7));
        System.out.println("kakao2Solutuion.solution(643325633, 2) = " + kakao2Solutuion.solution(643125623, 2));
    }
}
