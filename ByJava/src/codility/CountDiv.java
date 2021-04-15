package codility;

/*class CountDivSolution {
    public int solution(int A, int B, int K) {
        int answer = 0;
        if (A == B) {
            if (A % K == 0) return 1;
        }
        for (int i = A; i < B; i++) {
            if (i % K == 0) {
                answer++;
            }
        }
        return answer;
    }
}*/

/*class Solution {
    public int solution(int A, int B, int K) {
        int answer = 0;
        if (A == B) {
            if (A % K == 0) return 1;
        }
        int i = A;
        for (; i < B; i++) {
            if (i % K == 0) {
                answer++;
                break;
            }
        }
        for (i = i - 1; i < B; i += K) {
            answer++;
        }
        return answer - 1;
    }
}*/

class CountDivSolution {
    public int solution(int A, int B, int K) {
        if (A % K == 0) return B / K  - A / K + 1;
        return B / K  - A / K;
    }
}

public class CountDiv {
    public static void main(String[] args) {
        CountDivSolution sol = new CountDivSolution();
        System.out.println(sol.solution(6, 11, 2) == 3);
        System.out.println(sol.solution(0, 1, 11) == 1);
        System.out.println(sol.solution(0, 14, 2) == 8);
        System.out.println(sol.solution(10, 10, 7) == 0);
        System.out.println(sol.solution(10, 10, 10) == 1);
        System.out.println(sol.solution(11, 345, 17) == 20);
    }
}
