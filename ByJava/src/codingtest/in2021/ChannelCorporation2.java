package codingtest.in2021;

class ChannelCorporationSolution2 {
    public int solution(int[][] t1, int[][] t2) {
        int answer = -1;
        return answer;
    }
}

public class ChannelCorporation2 {
    public static void main(String[] args) {
        ChannelCorporationSolution2 sol = new ChannelCorporationSolution2();
        System.out.println(sol.solution(
                new int[][]{{1, 2}, {3, 4}, {5, 6}, {-1, 7}, {8, 9}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                new int[][]{{1, 2}, {-1, -1}, {-1, -1}}
        ));

        System.out.println(sol.solution(
                new int[][]{{1, 2}, {3, 4}, {5, 6}, {-1, 7}, {8, 9}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}},
                new int[][]{{-1, 1}, {-1, -1}}
        ));


    }


}
