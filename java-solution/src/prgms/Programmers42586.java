package prgms;

import java.util.*;

class Solution42586 {
    static class Task {
        int id;
        int progress;
        int speed;

        public Task(int id, int progress, int speed) {
            this.id = id;
            this.progress = progress;
            this.speed = speed;
        }
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        Queue<Task> taskQueue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            Task task = new Task(i, progresses[i], speeds[i]);
            tasks.add(task);
            taskQueue.add(task);
        }

        while (!taskQueue.isEmpty()) {
            int completed = 0;
            for (Task task : tasks) {
                task.progress += task.speed;
            }
            for (Task task : tasks) {
                if (taskQueue.isEmpty()) break;
                if (taskQueue.peek().id == task.id && task.progress >= 100) {
                    taskQueue.poll();
                    completed++;
                }
            }
            if (completed > 0) {
                answer.add(completed);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

public class Programmers42586 {
    public static void main(String[] args) {
        Solution42586 sol = new Solution42586();
        System.out.println(Arrays.toString(sol.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
        System.out.println(Arrays.toString(sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})));
    }
}
