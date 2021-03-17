package codility;

class FrogJmpSolution {
    public int solution(int X, int Y, int D) {
        int answer = 0;
        int position = X;
        while (position < Y) {
            answer++;
            position += D;
        }
        return answer;
    }
}

public class FrogJmp {
    public static void main(String[] args) {
        FrogJmpSolution sol = new FrogJmpSolution();
        System.out.println(sol.solution(10, 85, 30));
    }
}
