package codingtest.in2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class WantedDevCarnival4Solution {
    void solution() {

    }
}

public class WantedDevCarnival4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WantedDevCarnival4Solution sol = new WantedDevCarnival4Solution();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            graph.get(n1).add(n2);
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("[%d] : %s\n", i, graph.get(i).toString());
        }
        System.out.println("------------------------------");

        List<List<Integer>> reversed = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            reversed.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.size(); i++) {
            List<Integer> list = graph.get(i);
            for (Integer value : list) {
                reversed.get(i).add(value);
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("[%d] : %s\n", i, graph.get(i).toString());
        }
    }
}

/*
        7 9
        2 1
        4 5
        3 6
        4 6
        1 3
        6 5
        5 2
        6 7
        4 1

        2 7

7 9
7 1
4 6
2 7
5 6
4 7
1 6
6 7
5 7
7 3

1 6

8 6
3 7
4 3
7 5
2 5
5 8
6 3

2 3

*/
