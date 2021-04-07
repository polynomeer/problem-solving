package codility;

class CountDivSolution {
    public int solution(int A, int B, int K) {
        int answer = 0;
        for (int i = A; i < B; i++) {
             if (i % K == 0) {
                 answer++;
             }
        }
        return answer;
    }
}

public class CountDiv {
    public static void main(String[] args) {
        CountDivSolution sol = new CountDivSolution();
        System.out.println(sol.solution(6, 11, 2) == 3);
    }
}
