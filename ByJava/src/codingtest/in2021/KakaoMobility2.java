package codingtest.in2021;

import java.util.Arrays;

class KakaoMobility2Solution {
    /**
     * @param T the array that represents the skill tree
     * @param A the skill to be acquired
     * @return the minimum number of skills which have to be learned to acquire A
     */
    public int solution(int[] T, int[] A) {
        int answer = 0;
        boolean[] visited = new boolean[T.length];
        visited[0] = true;

        for (int a : A) {
            int index = a;
            while (true) {
                if (T[index] == 0) {
                    visited[index] = true;
                    break;
                } else {
                    visited[index] = true;
                    index = T[index];
                }
            }
        }

        for (boolean v : visited) {
            if (v) answer++;
        }

        return answer;
    }
}


public class KakaoMobility2 {
    public static void main(String[] args) {
        KakaoMobility2Solution sol = new KakaoMobility2Solution();
        System.out.println(sol.solution(new int[]{0, 0, 1, 1}, new int[]{2}) == 3);
        System.out.println(sol.solution(new int[]{0, 0, 0, 0, 2, 3, 3}, new int[]{2, 5, 6}) == 5);
        System.out.println(sol.solution(new int[]{0, 0, 1, 2}, new int[]{1, 2}) == 3);
        System.out.println(sol.solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0}) == 7);
    }


}
