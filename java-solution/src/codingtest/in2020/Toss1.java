package codingtest.in2020;

class SolutionToss1 {
    public boolean solution(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '1' && c[i + 1] != '2') {
                return false;
            }
        }
        return c[c.length - 1] != '1';
    }
}

public class Toss1 {
    public static void main(String[] args) {
        SolutionToss1 sol = new SolutionToss1();
        System.out.println(sol.solution("11"));
        System.out.println(sol.solution("12"));
        System.out.println(sol.solution("121"));
        System.out.println(sol.solution("122"));
    }
}
