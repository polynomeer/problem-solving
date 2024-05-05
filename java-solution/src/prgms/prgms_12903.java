package prgms;

class Solution_12903 {
    public String solution(String s) {
        return s.length() % 2 == 0 ?
                s.substring(s.length() / 2 - 1, s.length() / 2 + 1) :
                s.substring(s.length() / 2, s.length() / 2 + 1);
    }
}

public class prgms_12903 {
    public static void main(String[] args) {
        Solution_12903 sol = new Solution_12903();
        System.out.println(sol.solution("hello"));
        System.out.println(sol.solution("abcde"));
        System.out.println(sol.solution("qwer"));
    }
}
