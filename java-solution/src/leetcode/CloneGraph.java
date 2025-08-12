package leetcode;

import java.util.*;

public class CloneGraph {

    /**
     * 그래프의 노드 정의 클래스
     * val: 노드의 값
     * neighbors: 인접한 이웃 노드 리스트
     */
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

    /**
     * Solution 클래스
     * - DFS와 BFS 두 방식으로 그래프를 복제
     * - 복제 전/후의 그래프 구조를 시각적으로 출력
     * - 복제가 깊은 복사인지 검증
     */
    static class Solution {
        // DFS에서 원본 노드 → 복제본 노드를 저장하는 Map
        private final Map<Node, Node> seen = new HashMap<>();

        /**
         * DFS(깊이 우선 탐색)로 그래프를 깊은 복사
         * 1. 입력이 null이면 null 반환
         * 2. 이미 복제한 노드라면 Map에서 복제본을 꺼내 반환
         * 3. 새로운 복제본 생성 후 Map에 저장
         * 4. 원본의 각 이웃을 재귀적으로 복제하여 복제본의 이웃 리스트에 추가
         */
        public Node cloneGraphDFS(Node node) {
            if (node == null) return null;
            if (seen.containsKey(node)) return seen.get(node);

            Node copy = new Node(node.val);
            seen.put(node, copy);

            for (Node nei : node.neighbors) {
                copy.neighbors.add(cloneGraphDFS(nei));
            }
            return copy;
        }

        /**
         * BFS(너비 우선 탐색)로 그래프를 깊은 복사
         * 1. null이면 null 반환
         * 2. Map에 시작 노드 복제본 저장, 큐에 원본 노드 삽입
         * 3. 큐에서 원본 노드를 꺼내 이웃을 순회
         * - 복제 안 된 이웃은 새 복제본 생성 후 Map과 큐에 등록
         * - 현재 복제본의 이웃 리스트에 이웃 복제본 추가
         */
        public Node cloneGraphBFS(Node node) {
            if (node == null) return null;

            Map<Node, Node> clones = new HashMap<>();
            Queue<Node> q = new LinkedList<>();

            clones.put(node, new Node(node.val));
            q.offer(node);

            while (!q.isEmpty()) {
                Node curr = q.poll();
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

        /**
         * 그래프 구조를 시각적으로 출력
         * - 각 노드와 그 이웃 노드들의 값, 객체 ID(System.identityHashCode)를 출력
         * - BFS 방식으로 탐색하여 모든 노드를 한 번씩만 출력
         */
        public static void printGraph(Node node, String title) {
            System.out.println("\n--- " + title + " ---");
            if (node == null) {
                System.out.println("그래프 없음");
                return;
            }

            Set<Node> visited = new HashSet<>();
            Queue<Node> q = new LinkedList<>();
            q.offer(node);

            while (!q.isEmpty()) {
                Node curr = q.poll();
                if (!visited.add(curr)) continue;

                // 현재 노드와 이웃 노드 정보 문자열 생성
                StringBuilder sb = new StringBuilder();
                sb.append("Node ").append(curr.val)
                        .append(" (id=").append(System.identityHashCode(curr)).append(")")
                        .append(" → [ ");

                for (Node nei : curr.neighbors) {
                    sb.append(nei.val)
                            .append("(id=").append(System.identityHashCode(nei)).append(") ");
                    q.offer(nei);
                }
                sb.append("]");

                System.out.println(sb.toString());
            }
        }

        /**
         * 복제본이 깊은 복사인지 검증
         * - 값은 같아야 하고
         * - 객체 참조(==)는 달라야 함
         * - BFS로 원본 탐색하며 각 노드의 복제본을 찾아 비교
         */
        public static void checkGraph(Node original, Node clone) {
            Set<Node> visited = new HashSet<>();
            Queue<Node> q = new LinkedList<>();
            q.offer(original);

            while (!q.isEmpty()) {
                Node o = q.poll();
                if (!visited.add(o)) continue;

                Node c = findNode(clone, o.val, new HashSet<>());
                if (c == null) {
                    System.out.printf("[검증] 실패: 복제본에서 값 %d 노드 없음\n", o.val);
                } else if (o == c) {
                    System.out.printf("[검증] 실패: 원본과 복제본이 동일 객체(%d)\n", o.val);
                } else {
                    System.out.printf("[검증] 성공: 원본 %d(id=%d) ↔ 복제본 %d(id=%d)\n",
                            o.val, System.identityHashCode(o),
                            c.val, System.identityHashCode(c));
                }

                for (Node nei : o.neighbors) {
                    q.offer(nei);
                }
            }
        }

        /**
         * 복제본 그래프에서 값으로 노드 찾기 (DFS)
         * - visited Set으로 무한 루프 방지
         */
        private static Node findNode(Node root, int val, Set<Node> visited) {
            if (root == null || !visited.add(root)) return null;
            if (root.val == val) return root;
            for (Node nei : root.neighbors) {
                Node found = findNode(nei, val, visited);
                if (found != null) return found;
            }
            return null;
        }

        /**
         * main 메서드: 테스트 실행
         * 1. 1-2-4-3의 사각형 구조 그래프 생성
         * 2. DFS로 복제 → 시각화 출력 → 검증
         * 3. BFS로 복제 → 시각화 출력 → 검증
         */
        public static void main(String[] args) {
            // 원본 그래프 생성: 1-2-4-3 사각형
            Node n1 = new Node(1);
            Node n2 = new Node(2);
            Node n3 = new Node(3);
            Node n4 = new Node(4);

            // 양방향 연결
            n1.neighbors.add(n2);
            n1.neighbors.add(n3);
            n2.neighbors.add(n1);
            n2.neighbors.add(n4);
            n3.neighbors.add(n1);
            n3.neighbors.add(n4);
            n4.neighbors.add(n2);
            n4.neighbors.add(n3);

            Solution sol = new Solution();

            // DFS 복제 테스트
            Node clonedDFS = sol.cloneGraphDFS(n1);
            printGraph(n1, "원본 그래프 (DFS)");
            printGraph(clonedDFS, "복제 그래프 (DFS)");
            checkGraph(n1, clonedDFS);

            // BFS 복제 테스트
            Node clonedBFS = sol.cloneGraphBFS(n1);
            printGraph(n1, "원본 그래프 (BFS)");
            printGraph(clonedBFS, "복제 그래프 (BFS)");
            checkGraph(n1, clonedBFS);
        }
    }


}
