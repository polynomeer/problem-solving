package prgms;

class Solution68935 {
    public int solution(int n) {
        if (n == 0) return n;
        long reversed = 0;
        while (n > 0) {
            reversed *= 10;
            reversed += n % 3;
            n /= 3;
        }
        int answer = 0;
        int power = 0;
        while (reversed > 0) {
            int multi = 1;
            for (int i = 0; i < power; i++) {
                multi *= 3;
            }
            long temp = (reversed % 10) * multi;
//            System.out.println("multi = " + multi + " temp = " + temp + " reversed = " + reversed + " power = " + power);
            answer += temp;
            power++;
            reversed /= 10;
        }

        return answer;
    }
}

public class Programmers68935 {
    public static void main(String[] args) {
        Solution68935 sol = new Solution68935();
        System.out.println(sol.solution(45));
        System.out.println(sol.solution(125));
        System.out.println(sol.solution(3));
        System.out.println(sol.solution(1));
        System.out.println(sol.solution(0));
        System.out.println(sol.solution(100000000));
    }
}
