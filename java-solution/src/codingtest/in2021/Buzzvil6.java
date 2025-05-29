package codingtest.in2021;

import java.util.*;


class BuzzvilSolution6_v1 {
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

class BuzzvilSolution6_v1_fixed {

    public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= graphNodes; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < graphFrom.size(); i++) {
            int u = graphFrom.get(i);
            int v = graphTo.get(i);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[graphNodes + 1];
        int sum = 0;

        for (int i = 1; i <= graphNodes; i++) {
            if (!visited[i]) {
                int count = dfs(i, graph, visited);
                sum += Math.ceil(Math.sqrt(count));
            }
        }

        return sum;
    }

    private static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return count;
    }
}


class BuzzvilSolution6_v2 {

    public static int connectedSum(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo) {
        int[] parent = new int[graphNodes + 1];  // 1-based
        for (int i = 1; i <= graphNodes; i++) parent[i] = i;

        // Union all edges
        for (int i = 0; i < graphFrom.size(); i++) {
            union(parent, graphFrom.get(i), graphTo.get(i));
        }

        // Count sizes of each connected component
        Map<Integer, Integer> componentSizes = new HashMap<>();
        for (int i = 1; i <= graphNodes; i++) {
            int root = find(parent, i);
            componentSizes.put(root, componentSizes.getOrDefault(root, 0) + 1);
        }

        // Sum ceil(sqrt(size)) for each component
        int total = 0;
        for (int size : componentSizes.values()) {
            total += Math.ceil(Math.sqrt(size));
        }

        return total;
    }

    private static int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);  // path compression
        return parent[x];
    }

    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            parent[rootY] = rootX;  // merge y into x
        }
    }
}

public class Buzzvil6 {
    public static void main(String[] args) {
        runTest(4, Arrays.asList(1, 1), Arrays.asList(2, 4), 3);
        runTest(8, Arrays.asList(8, 5, 7, 8), Arrays.asList(1, 8, 3, 6), 6);
        runTest(10, Arrays.asList(1, 1, 2, 3, 7), Arrays.asList(2, 3, 4, 5, 8), 8);
    }

    private static void runTest(int nodes, List<Integer> from, List<Integer> to, int expected) {
        int result = BuzzvilSolution6_v1_fixed.connectedSum(nodes, from, to);
        boolean passed = result == expected;
        System.out.printf("Test %s\n", passed ? "PASSED" : "FAILED");
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result);
        System.out.println();
    }
}

