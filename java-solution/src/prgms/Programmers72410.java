package prgms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution72410 {
    /*    public String solution(String new_id) {
            List<Character> forbidden = Arrays.asList('!', '@', '#', '*');
            List<Character> dots = Arrays.asList('!', '@', '#', '*');
            String answer = new_id.chars()
                    .mapToObj(c -> (char) c)
                    .map(Character::toLowerCase)
                    .map(c -> forbidden.contains((char) c) ? ' ' : c)
                    .collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append)
                    .toString();
            System.out.println(answer);
            return answer;
        }*/
    public String solution(String new_id) {
        String answer = new_id
                .toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("\\.+", ".");

        if (answer.length() > 0 && answer.charAt(0) == '.') answer = answer.substring(1);
        if (answer.length() == 0) answer = answer.concat("a");
        if (answer.length() >= 16) answer = answer.substring(0, 15);
        if (answer.charAt(answer.length() - 1) == '.') answer = answer.substring(0, answer.length() - 1);
        while (answer.length() <= 2) {
            answer += answer.charAt(answer.length() - 1);
        }
        return answer;
    }
}

public class Programmers72410 {
    public static void main(String[] args) {
        Solution72410 sol = new Solution72410();
        System.out.println(sol.solution("...!@BaT#*..y.abcdefghijklm").equals("bat.y.abcdefghi"));
        System.out.println(sol.solution("z-+.^.").equals("z--"));
        System.out.println(sol.solution("=.=").equals("aaa"));
        System.out.println(sol.solution("123_.def").equals("123_.def"));
        System.out.println(sol.solution("abcdefghijklmn.p").equals("abcdefghijklmn"));
    }
}
