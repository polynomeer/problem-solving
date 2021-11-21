package codingtest.in2021;

class SiliconValleySolution3 {
    public long solution(long[] wave1, long[] wave2) {
        long answer = -1;
        return answer;
    }
}

public class SiliconValley3 {
    public static void main(String[] args) {
        SiliconValleySolution3 sol = new SiliconValleySolution3();
        System.out.println(sol.solution(new long[]{1, 2, 2, 1, 1, 2}, new long[]{-2, -1}));
        System.out.println(sol.solution(new long[]{2, -1, 3}, new long[]{-1, -1}));
        System.out.println(sol.solution(new long[]{0, 1, 1, 1, 1, 1}, new long[]{0, 0, 1, 0, 0, 0}));
        System.out.println(sol.solution(new long[]{2, 0, 1, 1, 1, 0}, new long[]{0, 0, -1}));
    }
}
