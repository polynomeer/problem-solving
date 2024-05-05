package codingtest.in2021;

class IportforlioSolution1 {
    public int solution(int n) {
        return n - n / 2 - n / 3 + n / 6 * 2;
    }
}

public class Iportforlio1 {
    public static void main(String[] args) {
        IportforlioSolution1 sol = new IportforlioSolution1();
        System.out.println(sol.solution(2));
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(9));
        System.out.println(sol.solution(10));
    }
}
