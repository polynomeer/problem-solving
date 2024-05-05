package prgms.level2;

import java.util.*;

class Solution_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> crossing = new LinkedList<>();
        Queue<Integer> arrived = new LinkedList<>();
        int count = 0;
        for (int t : truck_weights) {
            waiting.add(t);
        }

        while (!waiting.isEmpty()) {
            if (!crossing.isEmpty()) {
                arrived.add(crossing.poll());
            }
            count++;
            System.out.println(count);
            System.out.println("waiting : " + waiting);
            System.out.println("crossing : " + crossing);
            System.out.println("arrived : " + arrived);
            System.out.println();

            int sum = 0;
            for (int truck : crossing) {
                sum += truck;
            }
            int truck = waiting.peek();
            if (crossing.size() <= bridge_length && sum + truck <= weight) {
                crossing.add(waiting.poll());
            }
            count++;
            System.out.println(count);
            System.out.println("waiting : " + waiting);
            System.out.println("crossing : " + crossing);
            System.out.println("arrived : " + arrived);
            System.out.println();
        }

        return count;
    }
}

public class prgms_42583 {
    public static void main(String[] args) {
        Solution_42583 sol = new Solution_42583();
        System.out.println(sol.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(sol.solution(100, 100, new int[]{1, 10}));
        System.out.println(sol.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}
