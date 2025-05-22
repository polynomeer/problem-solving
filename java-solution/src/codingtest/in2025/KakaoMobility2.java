package codingtest.in2025;

import java.util.*;

class KakaoMobility2Solution {
    public int solution(int[] T, int[] A) {
        Set<Integer> learned = new HashSet<>();

        for (int skill : A) {
            while (!learned.contains(skill)) {
                learned.add(skill);
                if (T[skill] == skill) break; // root reached (T[0] == 0)
                skill = T[skill];
            }
        }

        return learned.size();
    }
}

public class KakaoMobility2 {
    public static void main(String[] args) {
        KakaoMobility2Solution sol = new KakaoMobility2Solution();
        System.out.println(sol.solution(new int[]{0, 0, 1, 1}, new int[]{2}) == 3);
        System.out.println(sol.solution(new int[]{0, 0, 0, 2, 2, 3, 3}, new int[]{2, 5, 6}) == 5);
        System.out.println(sol.solution(new int[]{0, 0, 1, 2}, new int[]{1, 2}) == 3);
        System.out.println(sol.solution(new int[]{0, 3, 0, 0, 5, 0, 5}, new int[]{4, 2, 6, 1, 0}) == 7);
    }
}
