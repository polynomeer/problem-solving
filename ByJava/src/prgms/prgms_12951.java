package prgms;

class Solution_12951 {
    public String solution(String s) {
        if (s.length() < 1) return s;

        s = s.toLowerCase();
        char[] chars = s.toCharArray();

        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = Character.toUpperCase(chars[0]);
        }

        for (int i = 1; i < s.length(); i++) {
            if (chars[i - 1] == ' ' && chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }

        return String.valueOf(chars);
    }
}

public class prgms_12951 {
    public static void main(String[] args) {
        Solution_12951 sol = new Solution_12951();
        System.out.println(sol.solution("3people unFollowed me"));
        System.out.println(sol.solution("for the last week"));
        System.out.println(sol.solution("week"));
        System.out.println(sol.solution("last WEEK "));
        System.out.println(sol.solution("last     WEEK "));
        System.out.println(sol.solution(""));
        System.out.println(sol.solution("a"));
        System.out.println(sol.solution("1"));
    }
}
