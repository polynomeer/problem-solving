package codility;

import java.util.Arrays;

/*class Solution {
    public int[] solution(int N, int[] A) {
        int[] answer = new int[N];
        int max = 0;
        int accumulatedMax = 0;
        boolean maxCounterFlag = false;

        for (int a : A) {
            if (a <= N) {
                maxCounterFlag = false;
                answer[a - 1]++;
                max = Math.max(answer[a - 1], max);
            }
            if (a == N + 1 && !maxCounterFlag) {
                maxCounterFlag = true;
                answer = new int[N];
                accumulatedMax += max;
                max = 0;
            }
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] += accumulatedMax;
        }
        return answer;
    }
}*/

class MaxCountersSolution {
    int[] counter;
    int max;
    int accumulatedMax;

    private void initCounter(int N) {
        counter = new int[N];
        max = 0;
        accumulatedMax = 0;
    }

    public int[] solution(int N, int[] A) {
        initCounter(N);
        boolean maxCounterFlag = false;

        for (int a : A) {
            if (a <= N) {
                maxCounterFlag = false;
                increase(a);
            }
            if (a == N + 1 && !maxCounterFlag) {
                maxCounterFlag = true;
                counter = new int[N];
                maxCounter();
            }
        }

        for (int i = 0; i < counter.length; i++) {
            counter[i] += accumulatedMax;
        }

        return counter;
    }

    private void increase(int x) {
        counter[x - 1]++;
        max = Math.max(max, counter[x - 1]);
    }

    private void maxCounter() {
        accumulatedMax += max;
        max = 0;
    }
}

public class MaxCounters {
    public static void main(String[] args) {
        MaxCountersSolution sol = new MaxCountersSolution();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
        System.out.println(Arrays.toString(sol.solution(5, new int[]{6})));
        System.out.println(Arrays.toString(sol.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 4, 4, 4, 4, 4, 6})));
        System.out.println(Arrays.toString(sol.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 4, 4, 4, 4, 4, 4, 6})));
    }
}
