package codingtest.in2021;

import java.util.Arrays;

class Node {
    private Node left;
    private Node right;
    private String data;

    public Node(String data) {
        left = null;
        right = null;
        this.data = data;
    }

    public void makeLeftSubTree(Node sub) {
        if(this.left != null) {
            this.left = null;
        }
        this.left = sub;
    }

    public void makeRightSubTree(Node sub) {
        if(this.right != null) {
            this.right = null;
        }
        this.right = sub;
    }

    public String getData() {
        return this.data;
    }

    public Node getLeftSubTree() {
        return this.left;
    }

    public Node getRightSubTree() {
        return this.right;
    }
}


class Line4Solution {
    public String[] solution(String[] data, String word) {
        String[] answer = {};
        Node node1 = new Node("feature1");
        Node node2 = new Node("feature2");
        Node node3 = new Node("doll1");
        Node node4 = new Node("doll2");
        Node node5 = new Node("doll3");

        node1.makeLeftSubTree(node2);
        node1.makeRightSubTree(node3);
        node2.makeLeftSubTree(node4);
        node2.makeLeftSubTree(node5);

        System.out.println(node1.getData() + "'s left : " + node1.getLeftSubTree().getData());
        System.out.println(node1.getData() + "'s right : " + node1.getRightSubTree().getData());
        System.out.println(node2.getData() + "'s left : " + node2.getLeftSubTree().getData());
        System.out.println(node2.getData() + "'s right : " + node2.getRightSubTree().getData());

        return answer;
    }
}

public class Line4 {
    public static void main(String[] args) {
        Line4Solution sol = new Line4Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"1 BROWN 0", "2 CONY 0", "3 DOLL 1", "4 DOLL 2", "5 LARGE-BROWN 3", "6 SMALL-BROWN 3", "7 BLACK-CONY 4", "8 BROWN-CONY 4"},
                "BROWN"
        )));
        System.out.println(Arrays.toString(sol.solution(new String[]{"1 BROWN 0", "2 CONY 0", "3 DOLL 1", "4 DOLL 2", "5 LARGE-BROWN 3", "6 SMALL-BROWN 3", "7 BLACK-CONY 4", "8 BROWN-CONY 4"},
                "SALLY"
        )));
        System.out.println(Arrays.toString(sol.solution(new String[]{"1 ROOTA 0", "2 AA 1", "3 ZZZ 1", "4 AABAA 1", "5 AAAAA 1", "6 AAAA 1", "7 BAAAAAAA 1", "8 BBAA 1", "9 CAA 1", "10 ROOTB 0", "11 AA 10"},
                "AA"
        )));

    }
}
