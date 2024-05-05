package codingtest.in2021;

import java.util.Scanner;

class WantedDevCarnival2Solution {


    class Edge {
        int x, y, cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }


    void solution(int n, String[] board, int x1, int y1, int x2, int y2) {

    }

    int bfs(int x, int y) {
        return 0;
    }
}

    public class WantedDevCarnival2 {
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            WantedDevCarnival2Solution sol = new WantedDevCarnival2Solution();
            sol.solution(5,
                    new String[]{
                            "....X",
                            "....X",
                            "DD...",
                            ".....",
                            ".X..."},
                    2, 3, 2, 2);
            sol.solution(5,
                    new String[]{
                            "...DD",
                            ".....",
                            ".....",
                            "X....",
                            "....."},
                    4, 2, 2, 4);
            sol.solution(6,
                    new String[]{
                            "...XDX",
                            "X...X.",
                            "...X..",
                            "..XDX.",
                            "...X..",
                            "X....."},
                    5, 2, 2, 3);
        }
    }
