package boj;

import java.util.Scanner;

public class BaekJoon1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] chars = s.toCharArray();
        int zero = 0;
        int one = 0;

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i + 1] != chars[i]) {
                if (chars[i] == '0')
                    zero++;
                else
                    one++;
            }
        }

        if (chars[chars.length - 1] == '0')
            zero++;
        else
            one++;

        System.out.println(Math.min(zero, one));
    }
}
