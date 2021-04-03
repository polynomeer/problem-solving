package codingtest.in2021;

import java.util.ArrayList;
import java.util.Arrays;

class KakaoMakers3Solution {
    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};

        int trainCount = train.length;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < trainCount; i++) {
            int n1 = train[i][0];
            int n2 = train[i][1];

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        // TODO : DFS or BFS 로 방문자수 카운트 하고, 가장 높은 방문자 수를 가지는 기차역 지정
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(graph.get(i));
        }

        return answer;
    }
}


public class KakaoMakers3 {
    public static void main(String[] args) {
        KakaoMakers3Solution sol = new KakaoMakers3Solution();
        int[][] test1 = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {3, 5},
                {3, 6}
        };

        int[][] test2 = new int[][]{
                {1, 2},
                {1, 3},
                {2, 4}
        };

        int[][] test3 = new int[][]{
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5}
        };
        System.out.println(Arrays.toString(sol.solution(6, new int[]{1, 1, 1, 1, 1, 1}, test1)));
        System.out.println(Arrays.toString(sol.solution(4, new int[]{2, 1, 2, 2}, test2)));
        System.out.println(Arrays.toString(sol.solution(5, new int[]{1, 1, 2, 3, 4}, test3)));
    }
}
