package prgms;

import java.util.*;

class Solution_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue priorityQueue = new PriorityQueue(Collections.reverseOrder());

        for (int task : priorities) {
            priorityQueue.add(task);
            System.out.println(priorityQueue);
        }
        while (!priorityQueue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == (int) priorityQueue.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}

public class prgms_42587 {
    public static void main(String[] args) {
        Solution_42587 sol = new Solution_42587();
        System.out.println(sol.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
