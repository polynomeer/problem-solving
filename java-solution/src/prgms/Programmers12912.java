package prgms;

class Solution12912 {
    public long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        for (int i = min; i <= max; i++) {
            answer += i;
        }
        return answer;
    }
}

public class Programmers12912 {
    public static void main(String[] args) {
        Solution12912 sol = new Solution12912();
        System.out.println(sol.solution(3, 5));
        System.out.println(sol.solution(3, 3));
        System.out.println(sol.solution(5, 3));
    }
}
