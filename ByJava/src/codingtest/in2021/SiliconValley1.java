package codingtest.in2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SiliconValleySolution1 {
    public int[] solution(int rows, int columns, int[][] connections, int[][] queries) {
        int[] answer = new int[queries.length];
        Set<Integer> set = new HashSet<>();

        for (int[] connection : connections) {
            int num = getNum(connection);
            set.add(num);
        }

        for (Integer integer : set) {
            System.out.println(integer);
        }

        int index = 0;
        for (int[] query : queries) {
            int maxRow = Math.max(query[0], query[2]);
            int minRow = Math.min(query[0], query[2]);
            int maxColumn = Math.max(query[1], query[3]);
            int minColumn = Math.min(query[1], query[3]);

            calcConnection(answer, set, index, maxRow, minRow, maxColumn, minColumn);
            calcConnection(answer, set, index, maxColumn, minColumn, maxRow, minRow);

            index++;
        }

        return answer;
    }

    private void calcConnection(int[] answer, Set<Integer> set, int index, int maxRow, int minRow, int maxColumn, int minColumn) {
        for (int i = minRow; i <= maxRow; i++) {

            int num = getNum(new int[]{i, minColumn, i, minColumn - 1});
            if (set.contains(num)) {
                System.out.println("num = " + num);
                answer[index]++;
                set.remove(num);
            }

            num = getNum(new int[]{i, minColumn - 1, i, minColumn});
            if (set.contains(num)) {
                System.out.println("num = " + num);
                answer[index]++;
                set.remove(num);
            }

            num = getNum(new int[]{i, maxColumn, i, maxColumn + 1});
            if (set.contains(num)) {
                System.out.println("num = " + num);
                answer[index]++;
                set.remove(num);
            }

            num = getNum(new int[]{i, maxColumn + 1, i, maxColumn});
            if (set.contains(num)) {
                System.out.println("num = " + num);
                answer[index]++;
                set.remove(num);
            }
        }
    }

    private int getNum(int[] connection) {
        int num = 0;
        for (int c : connection) {
            num *= 10;
            num += c;
        }
        return num;
    }
}

public class SiliconValley1 {
    public static void main(String[] args) {

        SiliconValleySolution1 sol = new SiliconValleySolution1();
        System.out.println(Arrays.toString(sol.solution(4, 3,
                new int[][]{{1, 1, 2, 1}, {1, 2, 1, 3}, {1, 3, 2, 3}, {2, 2, 2, 3}, {2, 2, 3, 2}, {2, 3, 3, 3}, {3, 2, 3, 3}, {3, 2, 4, 2}, {4, 1, 4, 2}},
                new int[][]{{2, 2, 3, 1}, {1, 2, 4, 2}})));
        System.out.println(Arrays.toString(sol.solution(2, 2,
                new int[][]{{1, 1, 1, 2}, {2, 2, 1, 2}, {2, 1, 1, 1}, {2, 2, 2, 1}},
                new int[][]{{1, 1, 2, 2}, {1, 1, 2, 1}, {2, 1, 2, 2}})));
    }
}
