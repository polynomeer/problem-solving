package prgms;

public class Programmers12930 {
    public static void main(String[] args) {
        Solution12930 solution_12930 = new Solution12930();
        System.out.println(solution_12930.solution("try hello world"));
        System.out.println(solution_12930.solution("  test  this    codes"));
        System.out.println(solution_12930.solution("  TRY  HELLO    WORLD"));
        System.out.println(solution_12930.solution("  tRy heLlO    WOrld  "));
        System.out.println(solution_12930.solution("    aa"));
    }
}

//class Solution12930 {
//    public String solution(String s) {
//        StringBuilder answer = new StringBuilder();
//        String[] token = s.split("\\s+");
//
//        for (String t : token) {
//            for (int index = 0; index < t.length(); index++) {
//                if (index % 2 == 0) {
//                    answer.append(Character.toUpperCase(t.charAt(index)));
//                } else {
//                    answer.append(Character.toLowerCase(t.charAt(index)));
//                }
//            }
//            answer.append(" ");
//        }
//        return answer.toString().trim();
//    }
//}
class Solution12930 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer.append(" ");
                index = 0;
                continue;
            }
            if (index % 2 == 0) {
                answer.append(Character.toUpperCase(s.charAt(i)));
            } else {
                answer.append(Character.toLowerCase(s.charAt(i)));
            }
            index++;
        }
        return answer.toString();
    }
}
