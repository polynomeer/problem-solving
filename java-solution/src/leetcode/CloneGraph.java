package leetcode;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {
        private Map<Node, Node> seen = new HashMap<>();

        public Node cloneGraphDFS(Node node) {
            if (node == null) return null;
            if (seen.containsKey(node)) return seen.get(node);

            Node copy = new Node(node.val);
            seen.put(node, copy);

            System.out.printf("[DFS] 복제: 원본 %d (%d) -> 복제본 %d (%d)\n",
                    node.val, System.identityHashCode(node),
                    copy.val, System.identityHashCode(copy));

            for (Node nei : node.neighbors) {
                copy.neighbors.add(cloneGraphDFS(nei));
            }
            return copy;
        }

        public Node cloneGraphBFS(Node node) {
            if (node == null) return null;

            Map<Node, Node> clones = new HashMap<>();
            Queue<Node> q = new LinkedList<>();

            clones.put(node, new Node(node.val));
            q.offer(node);

            while (!q.isEmpty()) {
                Node curr = q.poll();
                System.out.printf("[BFS] 처리 중: 원본 %d (%d) -> 복제본 %d (%d)\n",
                        curr.val, System.identityHashCode(curr),
                        clones.get(curr).val, System.identityHashCode(clones.get(curr)));

                for (Node nei : curr.neighbors) {
                    if (!clones.containsKey(nei)) {
                        clones.put(nei, new Node(nei.val));
                        q.offer(nei);
                    }
                    clones.get(curr).neighbors.add(clones.get(nei));
                }
            }
            return clones.get(node);
        }

        public static void main(String[] args) {
            // 테스트 그래프 생성: 1 - 2, 1 - 3, 2 - 4, 3 - 4 (사각형)
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            Node n4 = new Node(4);

            n1.neighbors.add(n2);
            n1.neighbors.add(n3);
            n2.neighbors.add(n1);
            n2.neighbors.add(n4);
            n3.neighbors.add(n1);
            n3.neighbors.add(n4);
            n4.neighbors.add(n2);
            n4.neighbors.add(n3);

            Solution sol = new Solution();

            System.out.println("==== DFS 복제 ====");
            Node clonedDFS = sol.cloneGraphDFS(n1);
            checkGraph(n1, clonedDFS);

            System.out.println("\n==== BFS 복제 ====");
            Node clonedBFS = sol.cloneGraphBFS(n1);
            checkGraph(n1, clonedBFS);
        }

        // 검증 메서드: 값은 같고 객체는 달라야 함
        private static void checkGraph(Node original, Node clone) {
            Set<Node> visited = new HashSet<>();
            Queue<Node> q = new LinkedList<>();
            q.offer(original);

            while (!q.isEmpty()) {
                Node o = q.poll();
                if (!visited.add(o)) continue;

                Node c = findNode(clone, o.val, new HashSet<>());
                if (c == null) {
                    System.out.printf("[검증] 복제본에서 값 %d 노드 없음\n", o.val);
                    continue;
                }
                if (o == c) {
                    System.out.printf("[검증] 실패: 원본과 복제본이 동일 객체(%d)\n", o.val);
                } else {
                    System.out.printf("[검증] 성공: 원본 %d (%d) ↔ 복제본 %d (%d)\n",
                            o.val, System.identityHashCode(o),
                            c.val, System.identityHashCode(c));
                }

                for (Node nei : o.neighbors) {
                    q.offer(nei);
                }
            }
        }

        // 복제본 그래프에서 값으로 노드 찾기 (값이 유일하다는 가정)
        private static Node findNode(Node root, int val, Set<Node> visited) {
            if (root == null || !visited.add(root)) return null;
            if (root.val == val) return root;
            for (Node nei : root.neighbors) {
                Node found = findNode(nei, val, visited);
                if (found != null) return found;
            }
            return null;
        }
    }

}
