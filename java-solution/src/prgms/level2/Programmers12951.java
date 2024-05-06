package prgms.level2;

class Solution12951 {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);

        for (int i = 1; i < s.length(); i++) {
            if (chars[i - 1] == ' ')
                chars[i] = Character.toUpperCase(chars[i]);
        }

        return String.valueOf(chars);
    }
}

public class Programmers12951 {
    public static void main(String[] args) {
        Solution12951 sol = new Solution12951();
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
