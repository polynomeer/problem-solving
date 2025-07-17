package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReorderNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int element : arr) {
            stack.push(element);
        }
        for (int i = 0; i < arr.length; i++) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
