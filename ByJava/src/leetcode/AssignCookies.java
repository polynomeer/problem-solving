package leetcode;

import java.util.Arrays;

/*
// solution 1
class AssignCookiesSolution {
    public int findContentChildren(int[] g, int[] s) {
        int answer = 0;
        boolean[] isTaken = new boolean[s.length];

        Arrays.sort(g);
        Arrays.sort(s);

        for (int i = g.length - 1; i >= 0; i--) {
            for (int j = s.length - 1; j >= 0; j--) {
                if (g[i] <= s[j] && !isTaken[j]) {
                    isTaken[j] = true;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
*/

// solution 2
class AssignCookiesSolution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gCount = 0;
        int sCount = 0;

        while (gCount < g.length && sCount < s.length) {
            if (g[gCount] <= s[sCount]) {
                gCount++;
            }
            sCount++;
        }
        return gCount;
    }
}

public class AssignCookies {
    public static void main(String[] args) {
        AssignCookiesSolution sol = new AssignCookiesSolution();
        System.out.println(sol.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(sol.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
