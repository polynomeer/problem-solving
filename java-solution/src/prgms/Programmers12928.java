package prgms;

public class Programmers12928 {
    public static void main(String[] args) {
        Solution12928 sol = new Solution12928();
        System.out.println(sol.solution(12));
        System.out.println(sol.solution(5));
    }
}

class Solution12928 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) answer += i;
        }
        return answer;
    }

}
