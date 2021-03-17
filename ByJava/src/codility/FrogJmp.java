package codility;

class FrogJmpSolution {
    public int solution(int X, int Y, int D) {
        int answer = 0;
        while (X + answer * D < Y) {
            answer++;
        }
        return answer;
    }
}

public class FrogJmp {
    public static void main(String[] args) {
        FrogJmpSolution sol = new FrogJmpSolution();
        System.out.println(sol.solution(10, 85, 30));
        System.out.println(sol.solution(10, 85, 30));
        System.out.println(sol.solution(10, 85, 30));
    }
}
