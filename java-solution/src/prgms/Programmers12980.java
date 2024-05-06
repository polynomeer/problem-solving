package prgms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution12980 {
    public int solution(int n) {
        int ans = 0;
        ans = go(n, ans);
        return ans;
    }

    /**
     * @param n   남은 거리
     * @param ans 배터리 사용량
     * @return 최소 배터리 사용량
     */
    private int go(int n, int ans) {
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }

    /*private int go(int n) {
        return Integer.bitCount(n);
    }*/

    /*private int go(int n, int ans) {
        while (n > 0) {
            ans += n % 2;
            n /= 2;
        }
        return ans;
    }*/

    /*private int go(int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] cost = new int[n + 1];
        Arrays.fill(cost, -1);

        queue.offer(0);
        cost[0] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == n) {
                return cost[cur];
            }

            if (cur * 2 <= n && cost[cur * 2] == -1) {
                queue.offer(cur * 2);
                cost[cur * 2] = cost[cur];
            }

            if (cur + 1 <= n && cost[cur + 1] == -1) {
                queue.offer(cur + 1);
                cost[cur + 1] = cost[cur] + 1;
            }
        }
        return cost[n];
    }*/

/*
    private int go(int n, int ans) {
        if (n == 1) return ans + 1;
        else if (n % 2 == 1) return go(n / 2, ans + 1);
        else return go(n / 2, ans);
    }

    private int go(int n) {
        if (n == 1) return 1;
        else if (n % 2 == 1) return go(n / 2 + 1);
        else return go(n / 2);
    }
*/
}

public class Programmers12980 {
    public static void main(String[] args) {
        Solution12980 sol = new Solution12980();
        System.out.println(sol.solution(5) == 2);
        System.out.println(sol.solution(6) == 2);
        System.out.println(sol.solution(5000) == 5);
    }
}
