package codingtest.in2021;

class SolutionNaverFinancial2 {
    int solution(int[] A) {
        int n = A.length;
        int i = n - 1;
        int result = -1;
        int k = 0, maximal = 0;
        while (i > 0) {
            if (A[i] == 1) {
                k = k + 1;
                if (k >= maximal) {
                    maximal = k;
                    result = i;
                }
            } else
                k = 0;
            i = i - 1;
        }
//        if (A[i] == 1 && k + 1 > maximal)
//            result = 0;
        if (A[i] == 1 && (k + 1 > maximal || (k + 1 == 1 && maximal == 1)))
            result = 0;
        return result;
    }
}

public class NaverFinancial2 {
    public static void main(String[] args) {
        SolutionNaverFinancial2 sol = new SolutionNaverFinancial2();
        System.out.println(sol.solution(new int[]{0, 1, 1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(sol.solution(new int[]{0, 0}));
    }
}
