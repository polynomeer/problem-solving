package codingtest.in2021;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class BuzzvilResult6 {
    private static int n, m, sum, count;
    private static int[][] map;
    private static boolean[] visit;

    public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {
        n = graphNodes;
        m = graphFrom.size();
        map = new int[n + 1][n + 1];

        for (int i = 0; i < graphFrom.size() && m > 0; i++, m--) {
            int x = graphFrom.get(i);
            int y = graphTo.get(i);
            map[x][y] = map[y][x] = 1;
        }

        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                count = 0;
                dfs(i);
                sum += Math.ceil(Math.sqrt(count));

            }
        }

        return sum;
    }

    static void dfs(int node) {
        if (visit[node]) return;

        visit[node] = true;
        count++;

        for (int i = 1; i <= n; i++) {
            if (map[node][i] == 1) dfs(i);
        }
    }

}

public class Buzzvil6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int graphNodes = Integer.parseInt(graphNodesEdges[0]);
        int graphEdges = Integer.parseInt(graphNodesEdges[1]);

        List<Integer> graphFrom = new ArrayList<>();
        List<Integer> graphTo = new ArrayList<>();

        IntStream.range(0, graphEdges).forEach(i -> {
            try {
                String[] graphFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                graphFrom.add(Integer.parseInt(graphFromTo[0]));
                graphTo.add(Integer.parseInt(graphFromTo[1]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = BuzzvilResult6.connectedSum(graphNodes, graphFrom, graphTo);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
