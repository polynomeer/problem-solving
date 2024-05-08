package prgms;

import java.util.regex.Pattern;

class Solution_12918 {
    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) return false;
        return Pattern.matches("^[0-9]*$", s);
    }
}

public class prgms_12918 {
    public static void main(String[] args) {
        Solution_12918 sol = new Solution_12918();
        System.out.println(sol.solution("12345"));
        System.out.println(sol.solution("a234"));
        System.out.println(sol.solution("1234"));
    }
}
