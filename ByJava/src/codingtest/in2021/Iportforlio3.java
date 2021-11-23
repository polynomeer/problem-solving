package codingtest.in2021;

class IportforlioSolution3 {
    int[] dp = new int[100001];

    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i <= n; i++)
            dp[i] = i;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}

public class Iportforlio3 {
    public static void main(String[] args) {
        IportforlioSolution3 sol = new IportforlioSolution3();
        System.out.println(sol.solution(9));
        System.out.println(sol.solution(15));
        System.out.println(sol.solution(41));
    }
}
