package boj;

import java.util.Scanner;

public class BOJ_1076 {

    private static String[] resistance = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;
        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            input[i] = sc.next();
        }

        answer = getValue(input[0]);
        answer = (answer * 10) + getValue(input[1]);

        int pow = getValue(input[2]);
        for (int i = 0; i < pow; i++) {
            answer *= 10;
        }

        System.out.println(answer);
    }

    private static int getValue(String s) {
        for (int i = 0; i < resistance.length; i++) {
            if (s.equals(resistance[i])) {
                return i;
            }
        }
        return 0;
    }

}
