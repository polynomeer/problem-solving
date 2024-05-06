package prgms;

import java.util.regex.Pattern;

class Solution12918 {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        return Pattern.matches("^[0-9]*$", s);
    }
}

public class Programmers12918 {
    public static void main(String[] args) {
        Solution12918 sol = new Solution12918();
        System.out.println(sol.solution("12345"));
        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }
}
