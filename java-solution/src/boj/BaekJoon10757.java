package boj;

import java.util.Scanner;

public class BaekJoon10757 {
    private static String a, b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();

        a = reverse(a);
        b = reverse(b);
        padding();

        String answer = sum();
        answer = reverse(answer);
        System.out.println(answer);
    }

    private static String sum() {
        String result = "";
        int num = 0, carry = 0;

        for (int i = 0; i < a.length(); ++i) {
            int sumInt = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            num = sumInt % 10;
            result += Integer.toString(num);
            carry = sumInt / 10;
        }
        if (carry != 0) {
            result += Integer.toString(carry);
        }
        return result;
    }

    private static String reverse(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }

    private static void padding() {
        int maxLen = a.length() >= b.length() ? a.length() : b.length();
        while (a.length() < maxLen) {
            a += '0';
        }
        while (b.length() < maxLen) {
            b += '0';
        }
    }
}
