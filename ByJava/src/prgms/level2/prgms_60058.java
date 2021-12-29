package prgms.level2;

class Solution_60058 {
    public String solution(String p) {
        StringBuilder answer = new StringBuilder();
        if (p.equals("")) return answer.toString();

        String[] w = divide(p);
        if (checkRight(w[0])) {
            return w[0] + solution(w[1]);
        } else {
            answer = new StringBuilder("(");
            answer.append(solution(w[1]));
            answer.append(")");
            answer = new StringBuilder(answer.substring(1, answer.length() - 1));
            for (char c : p.toCharArray()) {
                if (c == '(') answer.append(')');
                if (c == ')') answer.append('(');
            }
        }
        return answer.toString();
    }

    private String[] divide(String p) {
        int countLeft = 0;
        int countRight = 0;
        String[] w = new String[2];
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') countLeft++;
            if (p.charAt(i) == ')') countRight++;
            if (countLeft == countRight) {
                String balanced = p.substring(0, i + 1);
                String unbalanced = p.substring(i + 1);
                System.out.println(balanced + ", " + unbalanced);
                w[0] = balanced;
                w[1] = unbalanced;
                return w;
            }
        }
        return w;
    }

    private boolean checkRight(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            if (p.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return true;
    }

}


public class prgms_60058 {
    public static void main(String[] args) {
        Solution_60058 sol = new Solution_60058();
        System.out.println(sol.solution("(()())()"));
        System.out.println(sol.solution(")("));
        System.out.println(sol.solution("()))((()"));
    }
}
