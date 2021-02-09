package prgms;

class Solution_60057 {
    public int solution(String s) {
        int answer = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder convert = new StringBuilder();
            String unit;
            int count = 1;
            unit = s.substring(0, i);

            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    convert.append(s.substring(j, s.length()));
                    break;
                }
                if (unit.equals(s.substring(j, (j + i)))) {
                    count++;
                } else {
                    if (count > 1) convert.append(Integer.toString(count));
                    convert.append(unit);
                    unit = s.substring(j, (j + i));
                    count = 1;
                }

            }
            if (count > 1) convert.append(Integer.toString(count));

            convert.append(unit);
//            System.out.println(convert);
            answer = Math.min(answer, convert.length());
        }
        return answer;
    }
}

public class prgms_60057 {
    public static void main(String[] args) {
        Solution_60057 sol = new Solution_60057();
        System.out.println(sol.solution("aabbaccc"));
        System.out.println(sol.solution("ababcdcdababcdcd"));
        System.out.println(sol.solution("abcabcdede"));
        System.out.println(sol.solution("abcabcabcabcdededededede"));
        System.out.println(sol.solution("xababcdcdababcdcd"));
    }
}
