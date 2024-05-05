package prgms.level2;

class Solution_60057 {
    public int solution(String s) {
        int answer = s.length();

        for (int unitSize = 1; unitSize <= s.length() / 2; unitSize++) {
            String convert = compress(s, unitSize);
            answer = Math.min(answer, convert.length());
        }

        return answer;
    }

    private String compress(String s, int i) {
        StringBuilder convert = new StringBuilder();
        String unit = s.substring(0, i);
        int count = 1;

        for (int j = i; j < s.length(); j += i) {
            if (j + i > s.length()) {
                convert.append(s.substring(j, s.length()));
                break;
            }
            String substring = s.substring(j, (j + i));
            if (unit.equals(substring)) {
                count++;
                continue;
            }
            if (count > 1) convert.append(Integer.toString(count));
            convert.append(unit);
            unit = substring;
            count = 1;
        }

        if (count > 1) convert.append(Integer.toString(count));
        convert.append(unit);

        return convert.toString();
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
